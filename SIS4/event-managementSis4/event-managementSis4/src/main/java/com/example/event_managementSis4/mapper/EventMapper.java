package com.example.event_managementSis4.mapper;

import com.example.event_managementSis4.dto.EventRequestDto;
import com.example.event_managementSis4.dto.EventResponseDto;
import com.example.event_managementSis4.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventResponseDto toResponseDto(Event event) {
        EventResponseDto dto = new EventResponseDto();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setOrganizerEmail(event.getOrganizerEmail());
        dto.setTicketPrice(event.getTicketPrice());
        dto.setAgeLimit(event.getAgeLimit());
        dto.setEventDate(event.getEventDate());
        return dto;
    }

    public Event toEntity(EventRequestDto dto) {
        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setOrganizerEmail(dto.getOrganizerEmail());
        event.setTicketPrice(dto.getTicketPrice());
        event.setAgeLimit(dto.getAgeLimit());
        event.setEventDate(dto.getEventDate());
        return event;
    }

    public void updateEntityFromDto(EventRequestDto dto, Event event) {
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setOrganizerEmail(dto.getOrganizerEmail());
        event.setTicketPrice(dto.getTicketPrice());
        event.setAgeLimit(dto.getAgeLimit());
        event.setEventDate(dto.getEventDate());
    }
}