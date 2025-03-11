package com.movies.demo.services.Showing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Showing;
import com.movies.demo.models.UserShowing;
import com.movies.demo.models.responses.ShowingStats;
import com.movies.demo.repository.ShowingRepository;
import com.movies.demo.repository.UserShowingRepository;

@Service
public class StatsService {
    
    @Autowired
    private ShowingRepository showingRepository;
    
    @Autowired
    private UserShowingRepository userShowingRepository;
    
    public ShowingStats getStats(long showingId) {
        Showing showing = showingRepository.findById(showingId).get();
        List<UserShowing> userShowings = userShowingRepository.findByShowing(showing);
        long money = (long) (userShowings.size() * showing.getPrice());
        int seatsOccupied = userShowings.size();
        int seatsAvailable = showing.getSeats() - userShowings.size();
        ShowingStats showingStats = new ShowingStats();
        showingStats.setMoney(money);
        showingStats.setAvailableSeats(seatsAvailable);
        showingStats.setOccupiedSeats(seatsOccupied);
        return showingStats;
    }
}
