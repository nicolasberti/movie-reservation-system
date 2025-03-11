package com.movies.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Movie;
import com.movies.demo.models.Showing;
import com.movies.demo.models.User;
import com.movies.demo.models.UserShowing;
import com.movies.demo.models.exceptions.InvalidRequestException;
import com.movies.demo.models.requests.RequestDate;
import com.movies.demo.models.requests.RequestReserve;
import com.movies.demo.repository.MovieRepository;
import com.movies.demo.repository.ShowingRepository;
import com.movies.demo.repository.UserRepository;
import com.movies.demo.repository.UserShowingRepository;
import com.movies.demo.services.Showing.ReservationService;


@Service
public class ShowingService {

    @Autowired
    private ShowingRepository showingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserShowingRepository userShowingRepository;

    @Autowired
    private ReservationService reservationService;

    public List<Showing> getAll() {
        return showingRepository.findAll();
    }

    public List<Showing> getShowingMovieByDate(RequestDate requestDate) {
       if (Objects.isNull(requestDate.getId()) || requestDate.getDate() == null) {
            throw new InvalidRequestException("ID and date must not be null");
        }
        Movie movie = movieRepository.findById(requestDate.getId()).get();
        return showingRepository.findByMovieAndDate(movie, requestDate.getDate());
    }

    public List<Showing> getByDate(RequestDate requestDate) {
        return showingRepository.findByDate(requestDate.getDate());
    }

    public boolean reserve(RequestReserve requestReserve) {
        return reservationService.reserve(requestReserve);
    }

    public List<Integer> getSeats(long showingId) {
        List<Integer> seats = new ArrayList<Integer>();
        for(int i = 0; i < showingRepository.findById(showingId).get().getSeats(); i++) {
            if(!userShowingRepository.existsByShowingAndSeat(showingRepository.findById(showingId).get(), i)) {
                seats.add(i);
            }
        }
        return seats;
    }

}
