package com.movies.demo.services.Showing.utils;

import java.util.List;

import com.movies.demo.models.Showing;
import com.movies.demo.models.UserShowing;
import com.movies.demo.models.responses.ShowingStats;

public interface StatsCalculator {
    public ShowingStats calculateStats(Showing showing, List<UserShowing> userShowings);
}
