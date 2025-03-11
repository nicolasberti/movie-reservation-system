package com.movies.demo.dtos;

import com.movies.demo.models.Showing;

public class UserShowingDTO {
    private long id;

    private int seat;
    private Showing showing;

    public UserShowingDTO(long id, int seat, Showing showing){
        this.id = id;
        this.seat = seat;
        this.showing = showing;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public Showing getShowing() {
        return showing;
    }
    public void setShowing(Showing showing) {
        this.showing = showing;
    }
}
