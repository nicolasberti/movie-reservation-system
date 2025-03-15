package com.movies.demo.services.Showing;

import com.movies.demo.models.responses.ShowingStats;

public interface StatsService {
        public ShowingStats getStats(long showingId);
}
