package com.movies.demo.services.Showing;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Movie;
import com.movies.demo.models.Showing;
import com.movies.demo.models.exceptions.InvalidRequestException;
import com.movies.demo.models.requests.RequestDate;
import com.movies.demo.repository.MovieRepository;
import com.movies.demo.repository.ShowingRepository;

@Service
public class GetterServiceImpl implements GetterService {
    
    private ShowingRepository showingRepository;
    private MovieRepository movieRepository;

    public GetterServiceImpl(
        ShowingRepository showingRepository, 
        MovieRepository movieRepository
    ) {
        this.showingRepository = showingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Showing> getAll() {
        return showingRepository.findAll();
    }

    @Override
    public List<Showing> getShowingMovieByDate(RequestDate requestDate) {
       if (Objects.isNull(requestDate.getId()) || requestDate.getDate() == null) {
            throw new InvalidRequestException("ID and date must not be null");
        }
        Movie movie = movieRepository.findById(requestDate.getId()).get();
        return showingRepository.findByMovieAndDate(movie, requestDate.getDate());
    }

    @Override
    public List<Showing> getByDate(RequestDate requestDate) {
        return showingRepository.findByDate(requestDate.getDate());
    }
}
