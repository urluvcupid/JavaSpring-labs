package com.example.film_managmentSis5.service;

import com.example.film_managmentSis5.dto.FilmRequestDto;
import com.example.film_managmentSis5.dto.FilmResponseDto;
import com.example.film_managmentSis5.entity.Film;
import com.example.film_managmentSis5.exception.ResourceNotFoundException;
import com.example.film_managmentSis5.mapper.FilmMapper;
import com.example.film_managmentSis5.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private static final Logger log = LoggerFactory.getLogger(FilmService.class);

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public FilmService(FilmRepository filmRepository, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.filmMapper = filmMapper;
    }

    public FilmResponseDto createFilm(FilmRequestDto requestDto) {
        log.debug("Creating film with title={}", requestDto.getTitle());

        Film film = filmMapper.toEntity(requestDto);
        Film savedFilm = filmRepository.save(film);

        log.info("Film created successfully with id={}", savedFilm.getId());
        return filmMapper.toResponseDto(savedFilm);
    }

    public Page<FilmResponseDto> getAllFilms(Pageable pageable) {
        log.debug("Fetching films with pagination: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());

        Page<FilmResponseDto> page = filmRepository.findAll(pageable)
                .map(filmMapper::toResponseDto);

        log.info("Fetched {} films on current page", page.getNumberOfElements());
        return page;
    }

    public FilmResponseDto getFilmById(Long id) {
        log.debug("Fetching film by id={}", id);

        Film film = findFilmByIdOrThrow(id);
        log.info("Film found with id={}", id);

        return filmMapper.toResponseDto(film);
    }

    public FilmResponseDto updateFilm(Long id, FilmRequestDto requestDto) {
        log.debug("Updating film id={}", id);

        Film existingFilm = findFilmByIdOrThrow(id);
        filmMapper.updateEntityFromDto(requestDto, existingFilm);

        Film updatedFilm = filmRepository.save(existingFilm);

        log.info("Film updated successfully with id={}", updatedFilm.getId());
        return filmMapper.toResponseDto(updatedFilm);
    }

    public void deleteFilm(Long id) {
        log.debug("Deleting film id={}", id);

        Film film = findFilmByIdOrThrow(id);
        filmRepository.delete(film);

        log.info("Film deleted successfully with id={}", id);
    }

    private Film findFilmByIdOrThrow(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Film with id " + id + " not found"));
    }
}