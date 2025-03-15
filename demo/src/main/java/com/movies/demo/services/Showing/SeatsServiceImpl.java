package com.movies.demo.services.Showing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.repository.ShowingRepository;
import com.movies.demo.repository.UserShowingRepository;

@Service
public class SeatsServiceImpl implements SeatsService {
    
        @Autowired
        private ShowingRepository showingRepository;

        @Autowired
        private UserShowingRepository userShowingRepository;
        
        @Override
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
