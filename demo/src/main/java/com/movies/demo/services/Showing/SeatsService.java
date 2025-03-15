package com.movies.demo.services.Showing;

import java.util.List;

public interface SeatsService {
    public List<Integer> getSeats(long showingId);
}
