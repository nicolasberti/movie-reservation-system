package com.movies.demo.services;

import java.util.List;

import com.movies.demo.models.Showing;
import com.movies.demo.models.requests.RequestDate;
import com.movies.demo.models.requests.RequestReserve;
import com.movies.demo.models.responses.ShowingStats;

// facade
public interface ShowingService {
    public List<Showing> getAll();

    public List<Showing> getShowingMovieByDate(RequestDate requestDate);

    public List<Showing> getByDate(RequestDate requestDate);

    public boolean reserve(RequestReserve requestReserve);

    public List<Integer> getSeats(long showingId);

    public ShowingStats getStats(long showingId);
}
