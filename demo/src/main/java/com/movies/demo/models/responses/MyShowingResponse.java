package com.movies.demo.models.responses;

import com.movies.demo.models.Showing;

public class MyShowingResponse {
 
    private Showing showing;
    private int[] seats;
    public Showing getShowing() {
        return showing;
    }
    public void setShowing(Showing showing) {
        this.showing = showing;
    }
    public int[] getSeats() {
        return seats;
    }
    public void setSeats(int[] seats) {
        this.seats = seats;
    }
}
