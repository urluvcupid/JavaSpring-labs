package com.example.post_serviceSis6.service;

import com.example.post_serviceSis6.dto.CreatePostRequest;
import com.example.post_serviceSis6.dto.PostResponse;
import com.example.post_serviceSis6.entity.Post;
import com.example.post_serviceSis6.event.PostCreatedEvent;
import com.example.post_serviceSis6.exception.ResourceNotFoundException;
import com.example.post_serviceSis6.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    private static final String TOPIC_NAME = "posts";

    private final PostRepository postRepository;
    private final KafkaTemplate<String, PostCreatedEvent> kafkaTemplate;

    public PostService(PostRepository postRepository, KafkaTemplate<String, PostCreatedEvent> kafkaTemplate) {
        this.postRepository = postRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public PostResponse createPost(CreatePostRequest request) {
        UUID postId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();

        Post post = new Post();
        post.setId(postId);
        post.setUserId(request.getUserId());
        post.setContent(request.getContent());
        post.setHashtags(convertListToString(request.getHashtags()));
        post.setStatus("PUBLISHED");
        post.setCreatedAt(now);

        Post savedPost = postRepository.save(post);
        log.info("Post saved successfully with id={}", savedPost.getId());

        PostCreatedEvent event = new PostCreatedEvent(
                savedPost.getId().toString(),
                savedPost.getUserId(),
                savedPost.getContent(),
                convertStringToList(savedPost.getHashtags()),
                savedPost.getCreatedAt()
        );

        try {
            kafkaTemplate.send(TOPIC_NAME, savedPost.getId().toString(), event).get();
            log.info("PostCreatedEvent published to Kafka for postId={}", savedPost.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Kafka publishing was interrupted");
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to publish event to Kafka", e);
        }

        return mapToResponse(savedPost);
    }

    public PostResponse getPostById(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + postId + " not found"));

        return mapToResponse(post);
    }

    private PostResponse mapToResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getUserId(),
                post.getContent(),
                convertStringToList(post.getHashtags()),
                post.getStatus(),
                post.getCreatedAt()
        );
    }

    private String convertListToString(List<String> hashtags) {
        if (hashtags == null || hashtags.isEmpty()) {
            return "";
        }
        return String.join(",", hashtags);
    }

    private List<String> convertStringToList(String hashtags) {
        if (hashtags == null || hashtags.isBlank()) {
            return Collections.emptyList();
        }
        return List.of(hashtags.split(","));
    }
}