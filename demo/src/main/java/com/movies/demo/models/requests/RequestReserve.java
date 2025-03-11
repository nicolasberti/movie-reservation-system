package com.movies.demo.models.requests;

public class RequestReserve {
    public long showingId;
    public long userId;
    public int[] seats;
    public long getShowingId() {
        return showingId;
    }
    public void setShowingId(long showingId) {
        this.showingId = showingId;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public int[] getSeats() {
        return seats;
    }
    public void setSeats(int[] seats) {
        this.seats = seats;
    }
}
