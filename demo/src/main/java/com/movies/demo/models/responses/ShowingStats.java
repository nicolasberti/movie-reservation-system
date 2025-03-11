package com.movies.demo.models.responses;

public class ShowingStats {
    
    private long money;
    private int availableSeats;
    private int occupiedSeats;
    public long getMoney() {
        return money;
    }
    public void setMoney(long money) {
        this.money = money;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public int getOccupiedSeats() {
        return occupiedSeats;
    }
    public void setOccupiedSeats(int occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

}
