package com.example.film_managmentSis5.entity;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "films")
@Hidden
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(name = "director_name", nullable = false)
    private String directorName;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "age_rating", nullable = false)
    private Integer ageRating;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column
    private String synopsis;

    public Film() {
    }

    public Film(Long id, String title, String genre, String directorName, String contactEmail,
                Integer durationMinutes, Integer ageRating, LocalDate releaseDate, String synopsis) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.directorName = directorName;
        this.contactEmail = contactEmail;
        this.durationMinutes = durationMinutes;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public Integer getAgeRating() {
        return ageRating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setAgeRating(Integer ageRating) {
        this.ageRating = ageRating;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}