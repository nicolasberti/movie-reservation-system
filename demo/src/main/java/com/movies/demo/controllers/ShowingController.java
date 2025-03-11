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
import com.movies.demo.services.ShowingService;

@RestController
@RequestMapping("/showing")
public class ShowingController {
    
    @Autowired
    private ShowingService showingService;

    @GetMapping("/showings")
    public List<Showing> getShowings() {
        return showingService.getAll();
    }

    // Obtiene funciones de una pelicula por fecha
    @PostMapping("/getshowingmoviebydate")
    public List<Showing> getShowingMovieByDate(@RequestBody RequestDate requestDate) {
        return showingService.getShowingMovieByDate(requestDate);
    }

    // Obtiene funciones por fecha, sin importar que pelicula quiera
    @PostMapping("/getbydate")
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

    @PostMapping("/buy")
    public void buy(@RequestBody RequestDate requestDate) {
        
    }

    

}
