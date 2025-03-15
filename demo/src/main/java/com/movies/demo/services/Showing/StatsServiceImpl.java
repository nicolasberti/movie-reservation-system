package com.movies.demo.services.Showing;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movies.demo.models.Showing;
import com.movies.demo.models.UserShowing;
import com.movies.demo.models.responses.ShowingStats;
import com.movies.demo.repository.ShowingRepository;
import com.movies.demo.repository.UserShowingRepository;
import com.movies.demo.services.Showing.utils.StatsCalculator;

@Service
public class StatsServiceImpl implements StatsService{
    
    private final ShowingRepository showingRepository;
    private final UserShowingRepository userShowingRepository;
    private final StatsCalculator statsCalculator;

    public StatsServiceImpl(
        ShowingRepository showingRepository, 
        UserShowingRepository userShowingRepository, 
        StatsCalculator statsCalculator
    ) {
        this.showingRepository = showingRepository;
        this.userShowingRepository = userShowingRepository;
        this.statsCalculator = statsCalculator;
    }
    
    @Override
    public ShowingStats getStats(long showingId) {
        Showing showing = showingRepository.findById(showingId).get();
        List<UserShowing> userShowings = userShowingRepository.findByShowing(showing);
        return statsCalculator.calculateStats(showing, userShowings);
    }
}
