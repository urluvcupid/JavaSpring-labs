package com.example.event_managementSis4.dto;

import java.time.LocalDateTime;

public class EventResponseDto {

    private Long id;
    private String title;
    private String description;
    private String organizerEmail;
    private Integer ticketPrice;
    private Integer ageLimit;
    private LocalDateTime eventDate;

    public EventResponseDto() {
    }

    public EventResponseDto(Long id, String title, String description, String organizerEmail,
                            Integer ticketPrice, Integer ageLimit, LocalDateTime eventDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.organizerEmail = organizerEmail;
        this.ticketPrice = ticketPrice;
        this.ageLimit = ageLimit;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}