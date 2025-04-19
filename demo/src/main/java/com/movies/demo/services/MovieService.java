package com.movies.demo.services;

import com.movies.demo.dtos.movies.CreateMovieDTO;
import com.movies.demo.dtos.movies.UpdateMovieDTO;
import com.movies.demo.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    public Movie add(CreateMovieDTO movie);
    public Movie update(UpdateMovieDTO movie, Long id);
    public Movie delete(Long id);
    public Page<Movie> getAll(Pageable page);
}
