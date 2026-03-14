package com.example.feed_serviceSis6.service;

import com.example.feed_serviceSis6.entity.NotificationItem;
import com.example.feed_serviceSis6.event.PostCreatedEvent;
import com.example.feed_serviceSis6.repository.NotificationItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationItemRepository notificationItemRepository;

    public NotificationService(NotificationItemRepository notificationItemRepository) {
        this.notificationItemRepository = notificationItemRepository;
    }

    @KafkaListener(
            topics = "posts",
            groupId = "notification-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeForNotifications(PostCreatedEvent event) {
        if (event.getContent() == null || event.getContent().isBlank()) {
            log.warn("Skipping event {} — content is empty", event.getPostId());
            return;
        }

        NotificationItem notification = new NotificationItem();
        notification.setPostId(UUID.fromString(event.getPostId()));
        notification.setUserId(event.getUserId());
        notification.setMessage("New post from user " + event.getUserId() + ": " + event.getPostId());
        notification.setCreatedAt(event.getTimestamp());

        notificationItemRepository.save(notification);

        log.info("🔔 Sending push notification to followers of user {} — new post {}",
                event.getUserId(), event.getPostId());
    }
}