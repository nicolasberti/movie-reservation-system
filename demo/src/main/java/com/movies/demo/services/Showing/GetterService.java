package com.movies.demo.services.Showing;

import java.util.List;

import com.movies.demo.models.Showing;
import com.movies.demo.models.requests.RequestDate;

public interface GetterService {
    public List<Showing> getAll();

    public List<Showing> getShowingMovieByDate(RequestDate requestDate);

    public List<Showing> getByDate(RequestDate requestDate);   
}
