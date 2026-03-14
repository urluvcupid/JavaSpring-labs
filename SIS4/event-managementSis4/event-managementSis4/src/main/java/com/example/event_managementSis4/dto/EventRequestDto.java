package com.example.event_managementSis4.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class EventRequestDto {

    @NotNull(message = "Title must not be null")
    private String title;

    private String description;

    @NotNull(message = "Organizer email must not be null")
    @Email(message = "Organizer email must be valid")
    private String organizerEmail;

    @NotNull(message = "Ticket price must not be null")
    @Min(value = 0, message = "Ticket price must be >= 0")
    private Integer ticketPrice;

    @NotNull(message = "Age limit must not be null")
    @Min(value = 0, message = "Age limit must be >= 0")
    private Integer ageLimit;

    @NotNull(message = "Event date must not be null")
    private LocalDateTime eventDate;

    public EventRequestDto() {
    }

    public EventRequestDto(String title, String description, String organizerEmail,
                           Integer ticketPrice, Integer ageLimit, LocalDateTime eventDate) {
        this.title = title;
        this.description = description;
        this.organizerEmail = organizerEmail;
        this.ticketPrice = ticketPrice;
        this.ageLimit = ageLimit;
        this.eventDate = eventDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}