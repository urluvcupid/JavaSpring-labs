package com.example.film_managmentSis5.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "Request body for creating or updating a film")
public class FilmRequestDto {

    @Schema(description = "Film title", example = "Inception")
    @NotBlank(message = "Title must not be blank")
    @Size(min = 2, max = 150, message = "Title length must be between 2 and 150")
    private String title;

    @Schema(description = "Film genre", example = "Science Fiction")
    @NotBlank(message = "Genre must not be blank")
    @Size(min = 3, max = 80, message = "Genre length must be between 3 and 80")
    private String genre;

    @Schema(description = "Director full name", example = "Christopher Nolan")
    @NotBlank(message = "Director name must not be blank")
    @Size(min = 3, max = 120, message = "Director name length must be between 3 and 120")
    private String directorName;

    @Schema(description = "Contact email for film management", example = "nolan@filmsite.com")
    @NotBlank(message = "Contact email must not be blank")
    @Email(message = "Contact email must be valid")
    private String contactEmail;

    @Schema(description = "Film duration in minutes", example = "148")
    @NotNull(message = "Duration must not be null")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer durationMinutes;

    @Schema(description = "Minimum recommended age", example = "13")
    @NotNull(message = "Age rating must not be null")
    @Min(value = 0, message = "Age rating must be 0 or higher")
    private Integer ageRating;

    @Schema(description = "Film release date", example = "2010-07-16")
    @NotNull(message = "Release date must not be null")
    private LocalDate releaseDate;

    @Schema(description = "Short film synopsis", example = "A thief enters dreams to steal secrets.")
    @Size(max = 1000, message = "Synopsis must be at most 1000 characters")
    private String synopsis;

    public FilmRequestDto() {
    }

    public FilmRequestDto(String title, String genre, String directorName, String contactEmail,
                          Integer durationMinutes, Integer ageRating, LocalDate releaseDate, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.directorName = directorName;
        this.contactEmail = contactEmail;
        this.durationMinutes = durationMinutes;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
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