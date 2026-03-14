package com.example.post_serviceSis6.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "Response body containing post data")
public class PostResponse {

    @Schema(description = "Post ID", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID postId;

    @Schema(description = "User ID", example = "user-42")
    private String userId;

    @Schema(description = "Post content", example = "Hello Kafka!")
    private String content;

    @Schema(description = "List of hashtags", example = "[\"kafka\", \"spring\"]")
    private List<String> hashtags;

    @Schema(description = "Publication status", example = "PUBLISHED")
    private String status;

    @Schema(description = "Creation time", example = "2026-03-14T18:20:00")
    private LocalDateTime createdAt;

    public PostResponse() {
    }

    public PostResponse(UUID postId, String userId, String content, List<String> hashtags, String status, LocalDateTime createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.hashtags = hashtags;
        this.status = status;
        this.createdAt = createdAt;
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

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}