package com.movies.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Showing;
import com.movies.demo.models.requests.RequestDate;
import com.movies.demo.models.requests.RequestReserve;
import com.movies.demo.models.responses.ShowingStats;
import com.movies.demo.services.Showing.GetterService;
import com.movies.demo.services.Showing.ReservationService;
import com.movies.demo.services.Showing.SeatsService;
import com.movies.demo.services.Showing.StatsService;


@Service
public class ShowingServiceImpl implements ShowingService {

    private SeatsService seatsService;
    private ReservationService reservationService;
    private StatsService statsService;
    private GetterService getterService;

    public ShowingServiceImpl(
        SeatsService seatsService, 
        ReservationService reservationService, 
        StatsService statsService, 
        GetterService getterService
    ) {
        this.seatsService = seatsService;
        this.reservationService = reservationService;
        this.statsService = statsService;
        this.getterService = getterService;
    }
    
    @Override
    public List<Showing> getAll() {
        return getterService.getAll();
    }

    @Override
    public List<Showing> getShowingMovieByDate(RequestDate requestDate) {
       return getterService.getShowingMovieByDate(requestDate);
    }

    @Override
    public List<Showing> getByDate(RequestDate requestDate) {
        return getterService.getByDate(requestDate);
    }

    @Override
    public boolean reserve(RequestReserve requestReserve) {
        return reservationService.reserve(requestReserve);
    }

    @Override
    public List<Integer> getSeats(long showingId) {
        return seatsService.getSeats(showingId);
    }

    @Override
    public ShowingStats getStats(long showingId) {
        return statsService.getStats(showingId);
    }

}
