package com.example.film_managmentSis5.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Response body with film data")
public class FilmResponseDto {

    @Schema(description = "Film id", example = "1")
    private Long id;

    @Schema(description = "Film title", example = "Inception")
    private String title;

    @Schema(description = "Film genre", example = "Science Fiction")
    private String genre;

    @Schema(description = "Director full name", example = "Christopher Nolan")
    private String directorName;

    @Schema(description = "Contact email for film management", example = "nolan@filmsite.com")
    private String contactEmail;

    @Schema(description = "Film duration in minutes", example = "148")
    private Integer durationMinutes;

    @Schema(description = "Minimum recommended age", example = "13")
    private Integer ageRating;

    @Schema(description = "Film release date", example = "2010-07-16")
    private LocalDate releaseDate;

    @Schema(description = "Short film synopsis", example = "A thief enters dreams to steal secrets.")
    private String synopsis;

    public FilmResponseDto() {
    }

    public FilmResponseDto(Long id, String title, String genre, String directorName, String contactEmail,
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