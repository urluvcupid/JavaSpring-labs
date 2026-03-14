package com.example.feed_serviceSis6.service;

import com.example.feed_serviceSis6.dto.FeedItemResponse;
import com.example.feed_serviceSis6.entity.FeedItem;
import com.example.feed_serviceSis6.event.PostCreatedEvent;
import com.example.feed_serviceSis6.repository.FeedItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class FeedService {

    private static final Logger log = LoggerFactory.getLogger(FeedService.class);

    private final FeedItemRepository feedItemRepository;

    public FeedService(FeedItemRepository feedItemRepository) {
        this.feedItemRepository = feedItemRepository;
    }

    @KafkaListener(
            topics = "posts",
            groupId = "feed-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumePostCreatedEvent(PostCreatedEvent event) {
        if (event.getContent() == null || event.getContent().isBlank()) {
            log.warn("Skipping event {} — content is empty", event.getPostId());
            return;
        }

        FeedItem item = new FeedItem();
        item.setPostId(UUID.fromString(event.getPostId()));
        item.setUserId(event.getUserId());
        item.setContent(event.getContent());
        item.setHashtags(convertListToString(event.getHashtags()));
        item.setCreatedAt(event.getTimestamp());

        feedItemRepository.save(item);

        log.info(" Adding post {} by user {} to follower feeds — '{}'",
                event.getPostId(), event.getUserId(), event.getContent());
    }

    public List<FeedItemResponse> getFeedByUserId(String userId) {
        return feedItemRepository.findByUserIdOrderByCreatedAtDesc(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private FeedItemResponse mapToResponse(FeedItem item) {
        return new FeedItemResponse(
                item.getId(),
                item.getPostId(),
                item.getUserId(),
                item.getContent(),
                convertStringToList(item.getHashtags()),
                item.getCreatedAt()
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