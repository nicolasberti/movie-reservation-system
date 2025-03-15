package com.movies.demo.services;

import java.util.List;

import com.movies.demo.models.Movie;

public interface MovieService {
    public Movie add(Movie movie);
    public Movie update(Movie movie);
    public String delete(Movie movie);
    public List<Movie> getAll();
}
