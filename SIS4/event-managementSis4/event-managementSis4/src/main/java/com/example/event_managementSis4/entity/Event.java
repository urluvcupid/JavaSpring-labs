package com.example.event_managementSis4.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "organizer_email", nullable = false)
    private String organizerEmail;

    @Column(name = "ticket_price", nullable = false)
    private Integer ticketPrice;

    @Column(name = "age_limit", nullable = false)
    private Integer ageLimit;

    @Column(name = "event_date", nullable = false)
    private LocalDateTime eventDate;

    @Column
    private String description;

    public Event() {
    }

    public Event(Long id, String title, String organizerEmail, Integer ticketPrice,
                 Integer ageLimit, LocalDateTime eventDate, String description) {
        this.id = id;
        this.title = title;
        this.organizerEmail = organizerEmail;
        this.ticketPrice = ticketPrice;
        this.ageLimit = ageLimit;
        this.eventDate = eventDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setDescription(String description) {
        this.description = description;
    }
}