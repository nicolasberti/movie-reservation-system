package com.movies.demo.services.Showing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.demo.models.Showing;
import com.movies.demo.models.User;
import com.movies.demo.models.UserShowing;
import com.movies.demo.models.requests.RequestReserve;
import com.movies.demo.repository.ShowingRepository;
import com.movies.demo.repository.UserRepository;
import com.movies.demo.repository.UserShowingRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {
    
    @Autowired
    private ShowingRepository showingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserShowingRepository userShowingRepository;

    @Override
    @Transactional
    public boolean reserve(RequestReserve requestReserve) {
        Showing showing = showingRepository.findById(requestReserve.getShowingId())
                .orElseThrow(() -> new RuntimeException("Showing no encontrado"));
        
        User user = userRepository.findById(requestReserve.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        int[] seats = requestReserve.getSeats();

        for (int seat : seats) {
            if (userShowingRepository.existsByShowingAndSeat(showing, seat)) {
                throw new RuntimeException("El asiento " + seat + " ya está reservado");
            }
            userShowingRepository.save(new UserShowing(user, showing, seat));
        }
        
        return true;
    }
}
