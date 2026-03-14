package com.example.event_managementSis4.repository;

import com.example.event_managementSis4.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
