package com.example.feed_serviceSis6.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "feed_items")
public class FeedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id", nullable = false)
    private UUID postId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(nullable = false)
    private String content;

    @Column
    private String hashtags;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public FeedItem() {
    }

    public FeedItem(Long id, UUID postId, String userId, String content, String hashtags, LocalDateTime createdAt) {
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

    public String getHashtags() {
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

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}