package com.movies.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Movie;
import com.movies.demo.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        Movie movieAux = movieRepository.findById(movie.getId()).orElse(null);
        if(movieAux != null){
            if(movie.getName() != null){
                movieAux.setName(movie.getName());
            }
            if(movie.getDescription() != null){
                movieAux.setDescription(movie.getDescription());
            }
            if(movie.getImage() != null){
                movieAux.setImage(movie.getImage());
            }
            if(movie.getGender() != null){
                movieAux.setGender(movie.getGender());
            }
            movieRepository.save(movieAux);
        }
        return movieAux;
    }

    @Override
    public String delete(Movie movie) {
        Movie movieAux = movieRepository.findById(movie.getId()).orElse(null);
        if(movieAux != null){
            movieRepository.delete(movieAux);
            return "Movie deleted";
        }
        return "Movie not found";
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

}
