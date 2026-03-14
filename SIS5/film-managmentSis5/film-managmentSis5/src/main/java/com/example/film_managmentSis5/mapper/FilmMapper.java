package com.example.film_managmentSis5.mapper;

import com.example.film_managmentSis5.dto.FilmRequestDto;
import com.example.film_managmentSis5.dto.FilmResponseDto;
import com.example.film_managmentSis5.entity.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    public FilmResponseDto toResponseDto(Film film) {
        return new FilmResponseDto(
                film.getId(),
                film.getTitle(),
                film.getGenre(),
                film.getDirectorName(),
                film.getContactEmail(),
                film.getDurationMinutes(),
                film.getAgeRating(),
                film.getReleaseDate(),
                film.getSynopsis()
        );
    }

    public Film toEntity(FilmRequestDto dto) {
        Film film = new Film();
        film.setTitle(dto.getTitle());
        film.setGenre(dto.getGenre());
        film.setDirectorName(dto.getDirectorName());
        film.setContactEmail(dto.getContactEmail());
        film.setDurationMinutes(dto.getDurationMinutes());
        film.setAgeRating(dto.getAgeRating());
        film.setReleaseDate(dto.getReleaseDate());
        film.setSynopsis(dto.getSynopsis());
        return film;
    }

    public void updateEntityFromDto(FilmRequestDto dto, Film film) {
        film.setTitle(dto.getTitle());
        film.setGenre(dto.getGenre());
        film.setDirectorName(dto.getDirectorName());
        film.setContactEmail(dto.getContactEmail());
        film.setDurationMinutes(dto.getDurationMinutes());
        film.setAgeRating(dto.getAgeRating());
        film.setReleaseDate(dto.getReleaseDate());
        film.setSynopsis(dto.getSynopsis());
    }
}