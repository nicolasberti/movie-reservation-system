package com.movies.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.demo.models.Movie;
import com.movies.demo.services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    // solo admin
    public ResponseEntity<Movie> crearAuto(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieService.add(movie), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    // solo admin
    public ResponseEntity<Movie> actualizarMovie(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieService.update(movie), HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    // solo admin
    public ResponseEntity<String> deleteMovie(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieService.delete(movie), HttpStatus.CREATED);
    }
    
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAll();
    }

}
