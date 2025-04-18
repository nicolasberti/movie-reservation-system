package com.movies.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movies.demo.models.Showing;
import com.movies.demo.models.requests.RequestDate;
import com.movies.demo.models.requests.RequestReserve;
import com.movies.demo.models.responses.ShowingStats;
import com.movies.demo.services.ShowingService;

@RestController
@RequestMapping("/showings")
public class ShowingController {
    
    private ShowingService showingService;

    public ShowingController(
        ShowingService showingService
    ) {
        this.showingService = showingService;
    }

    @GetMapping("/")
    public List<Showing> getShowings() {
        return showingService.getAll();
    }

    @PostMapping("/date/movie")
    public List<Showing> getShowingMovieByDate(@RequestBody RequestDate requestDate) {
        return showingService.getShowingMovieByDate(requestDate);
    }

    @PostMapping("/date")
    public List<Showing> getByDate(@RequestBody RequestDate requestDate) {
        return showingService.getByDate(requestDate);
    }

    @PostMapping("/reserve")
    public boolean reserve(@RequestBody RequestReserve requestReserve) {
        try {
            return showingService.reserve(requestReserve);
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/seats")
    public List<Integer> getSeats(@RequestParam long showingId) {
        return showingService.getSeats(showingId);
    }

    /*@GetMapping("/stats")
    public ResponseEntity<ShowingStats> getStats(@RequestParam long showingId) {
        return new ResponseEntity(showingService.getStats(showingId), HttpStatus.CREATED);
    }*/
    @GetMapping("/stats")
    public ShowingStats getStats(@RequestParam long showingId) {
        return showingService.getStats(showingId);
    }

    

}
