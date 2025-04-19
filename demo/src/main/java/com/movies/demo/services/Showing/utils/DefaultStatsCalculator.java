package com.movies.demo.services.Showing.utils;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.movies.demo.models.Showing;
import com.movies.demo.models.UserShowing;
import com.movies.demo.models.responses.ShowingStats;

@Component
@Primary
public class DefaultStatsCalculator  implements StatsCalculator {

    @Override
    public ShowingStats calculateStats(Showing showing, List<UserShowing> userShowings) {
        long money = (long) (userShowings.size() * showing.getPrice());
        int seatsOccupied = userShowings.size();
        int seatsAvailable = showing.getSeats() - seatsOccupied;

        return new ShowingStats(money, seatsOccupied, seatsAvailable);
    }


}

