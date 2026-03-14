package com.example.feed_serviceSis6.event;

import java.time.LocalDateTime;
import java.util.List;

public class PostCreatedEvent {

    private String postId;
    private String userId;
    private String content;
    private List<String> hashtags;
    private LocalDateTime timestamp;

    public PostCreatedEvent() {
    }

    public PostCreatedEvent(String postId, String userId, String content, List<String> hashtags, LocalDateTime timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.hashtags = hashtags;
        this.timestamp = timestamp;
    }

    public String getPostId() {
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setPostId(String postId) {
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

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}