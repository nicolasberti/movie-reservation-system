package com.movies.demo.services;

import com.movies.demo.dtos.movies.CreateMovieDTO;
import com.movies.demo.dtos.movies.UpdateMovieDTO;
import com.movies.demo.models.exceptions.InvalidRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Movie;
import com.movies.demo.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(
        MovieRepository movieRepository
    ) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie add(CreateMovieDTO movie) {
        Movie newMovie = new Movie();
        newMovie.setName(movie.getName());
        newMovie.setDescription(movie.getDescription());
        newMovie.setImage(movie.getImage());
        newMovie.setGender(movie.getGender());
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie update(UpdateMovieDTO movie, Long id) {
        Movie movieOnRepo = movieRepository.findById(id).orElseThrow(() -> new InvalidRequestException("Movie not found"));
        if(movie.getName() != null){
            movieOnRepo.setName(movie.getName());
        }
        if(movie.getDescription() != null){
            movieOnRepo.setDescription(movie.getDescription());
        }
        if(movie.getImage() != null){
            movieOnRepo.setImage(movie.getImage());
        }
        if(movie.getGender() != null){
            movieOnRepo.setGender(movie.getGender());
        }
        movieRepository.save(movieOnRepo);
        return movieOnRepo;
    }

    @Override
    public Movie delete(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new InvalidRequestException("Movie not found"));
        Movie newMovie = new Movie();
        newMovie.setId(movie.getId());
        newMovie.setName(movie.getName());
        newMovie.setDescription(movie.getDescription());
        newMovie.setImage(movie.getImage());
        newMovie.setGender(movie.getGender());
        movieRepository.delete(movie);
        return newMovie;
    }

    @Override
    public Page<Movie> getAll(Pageable page) {
        return movieRepository.findAll(page);
    }

}
