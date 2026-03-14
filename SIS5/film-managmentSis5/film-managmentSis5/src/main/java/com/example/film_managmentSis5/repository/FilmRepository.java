package com.example.film_managmentSis5.repository;

import com.example.film_managmentSis5.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}