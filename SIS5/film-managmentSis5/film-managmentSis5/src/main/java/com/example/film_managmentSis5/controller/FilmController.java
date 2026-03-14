package com.example.film_managmentSis5.controller;

import com.example.film_managmentSis5.dto.ErrorResponse;
import com.example.film_managmentSis5.dto.FilmRequestDto;
import com.example.film_managmentSis5.dto.FilmResponseDto;
import com.example.film_managmentSis5.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/films")
@Tag(name = "Film API", description = "Endpoints for managing films in the film management system")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @Operation(
            summary = "Create a new film",
            description = "Creates a film record in the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Film created successfully",
                    content = @Content(schema = @Schema(implementation = FilmResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<FilmResponseDto> createFilm(@Valid @RequestBody FilmRequestDto requestDto) {
        FilmResponseDto responseDto = filmService.createFilm(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get all films with pagination",
            description = "Returns films using page, size and sort query parameters"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Films retrieved successfully",
                    content = @Content(
                            schema = @Schema(implementation = FilmResponseDto.class),
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "content": [
                                                {
                                                  "id": 1,
                                                  "title": "Inception",
                                                  "genre": "Science Fiction",
                                                  "directorName": "Christopher Nolan",
                                                  "contactEmail": "nolan@filmsite.com",
                                                  "durationMinutes": 148,
                                                  "ageRating": 13,
                                                  "releaseDate": "2010-07-16",
                                                  "synopsis": "A thief enters dreams to steal secrets."
                                                }
                                              ],
                                              "pageable": {
                                                "pageNumber": 0,
                                                "pageSize": 5
                                              },
                                              "totalPages": 1,
                                              "totalElements": 1
                                            }
                                            """
                            )
                    )),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping
    public ResponseEntity<Page<FilmResponseDto>> getAllFilms(
            @ParameterObject
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        return ResponseEntity.ok(filmService.getAllFilms(pageable));
    }

    @Operation(
            summary = "Get film by id",
            description = "Returns a single film by its id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Film found",
                    content = @Content(schema = @Schema(implementation = FilmResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDto> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @Operation(
            summary = "Update film by id",
            description = "Updates all editable film fields"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Film updated successfully",
                    content = @Content(schema = @Schema(implementation = FilmResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseDto> updateFilm(@PathVariable Long id,
                                                      @Valid @RequestBody FilmRequestDto requestDto) {
        return ResponseEntity.ok(filmService.updateFilm(id, requestDto));
    }

    @Operation(
            summary = "Delete film by id",
            description = "Deletes a film from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Film deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}