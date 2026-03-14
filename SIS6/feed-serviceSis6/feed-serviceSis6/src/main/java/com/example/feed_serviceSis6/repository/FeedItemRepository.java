package com.example.feed_serviceSis6.repository;

import com.example.feed_serviceSis6.entity.FeedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedItemRepository extends JpaRepository<FeedItem, Long> {

    List<FeedItem> findByUserIdOrderByCreatedAtDesc(String userId);
}