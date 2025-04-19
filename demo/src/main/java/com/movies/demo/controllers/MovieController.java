package com.movies.demo.controllers;

import com.movies.demo.dtos.movies.CreateMovieDTO;
import com.movies.demo.dtos.movies.UpdateMovieDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movies.demo.models.Movie;
import com.movies.demo.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    
    private MovieService movieService;

    public MovieController(
        MovieService movieService
    ){
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Page<Movie>> getMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movie> movies = movieService.getAll(pageable);
        return ResponseEntity.ok(movies);
    }



    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody CreateMovieDTO movie) {
        return new ResponseEntity<>(this.movieService.add(movie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> actualizarMovie(@Valid @RequestBody UpdateMovieDTO movie, @Valid @PathVariable Long id) {
        return new ResponseEntity<>(this.movieService.update(movie, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(this.movieService.delete(id), HttpStatus.OK);
    }


}
