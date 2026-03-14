package com.example.feed_serviceSis6.repository;

import com.example.feed_serviceSis6.entity.NotificationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationItemRepository extends JpaRepository<NotificationItem, Long> {
}