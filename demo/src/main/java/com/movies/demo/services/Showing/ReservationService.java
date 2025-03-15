package com.movies.demo.services.Showing;

import com.movies.demo.models.requests.RequestReserve;

public interface ReservationService {
    public boolean reserve(RequestReserve requestReserve);
}
