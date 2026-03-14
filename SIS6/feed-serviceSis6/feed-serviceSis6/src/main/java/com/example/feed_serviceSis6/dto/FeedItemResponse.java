package com.example.feed_serviceSis6.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "One item in the user's feed")
public class FeedItemResponse {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID postId;

    @Schema(example = "u1")
    private String userId;

    @Schema(example = "Hello Kafka world!")
    private String content;

    @Schema(example = "[\"kafka\", \"spring\"]")
    private List<String> hashtags;

    @Schema(example = "2026-03-14T23:10:00")
    private LocalDateTime createdAt;

    public FeedItemResponse() {
    }

    public FeedItemResponse(Long id, UUID postId, String userId, String content, List<String> hashtags, LocalDateTime createdAt) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.hashtags = hashtags;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public UUID getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}