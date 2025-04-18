package com.movies.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    public ResponseEntity<Movie> crearAuto(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieService.add(movie), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Movie> actualizarMovie(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieService.update(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteMovie(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieService.delete(movie), HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    public List<Movie> getMovies() {
        return movieService.getAll();
    }

}
