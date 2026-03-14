package com.example.event_managementSis4.service;

import com.example.event_managementSis4.dto.EventRequestDto;
import com.example.event_managementSis4.dto.EventResponseDto;
import com.example.event_managementSis4.entity.Event;
import com.example.event_managementSis4.exception.ResourceNotFoundException;
import com.example.event_managementSis4.mapper.EventMapper;
import com.example.event_managementSis4.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public EventResponseDto createEvent(EventRequestDto requestDto) {
        log.debug("Creating event with title={}", requestDto.getTitle());

        Event event = eventMapper.toEntity(requestDto);
        Event savedEvent = eventRepository.save(event);

        log.info("Event created successfully with id={}", savedEvent.getId());
        return eventMapper.toResponseDto(savedEvent);
    }

    public List<EventResponseDto> getAllEvents() {
        log.debug("Fetching all events");

        List<EventResponseDto> events = eventRepository.findAll()
                .stream()
                .map(eventMapper::toResponseDto)
                .toList();

        log.info("Fetched {} events", events.size());
        return events;
    }

    public EventResponseDto getEventById(Long id) {
        log.debug("Fetching event by id={}", id);

        Event event = findEventByIdOrThrow(id);
        log.info("Event found with id={}", id);

        return eventMapper.toResponseDto(event);
    }

    public EventResponseDto updateEvent(Long id, EventRequestDto requestDto) {
        log.debug("Updating event id={}", id);

        Event existingEvent = findEventByIdOrThrow(id);
        eventMapper.updateEntityFromDto(requestDto, existingEvent);

        Event updatedEvent = eventRepository.save(existingEvent);

        log.info("Event updated successfully with id={}", updatedEvent.getId());
        return eventMapper.toResponseDto(updatedEvent);
    }

    public void deleteEvent(Long id) {
        log.debug("Deleting event id={}", id);

        Event event = findEventByIdOrThrow(id);
        eventRepository.delete(event);

        log.info("Event deleted successfully with id={}", id);
    }

    private Event findEventByIdOrThrow(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id " + id + " not found"));
    }
}