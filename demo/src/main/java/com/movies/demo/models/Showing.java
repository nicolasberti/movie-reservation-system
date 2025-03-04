package com.movies.demo.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table(name = "showings")
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int seats;
    private Date date;
    private float price;

    @ManyToOne
    @JoinColumn(name = "movies_id")
    @JsonIgnoreProperties("showings")
    private Movie movie;

    @OneToMany(mappedBy = "showing")
    @JsonIgnoreProperties("showing") // sirve para ignorar propiedades del json
    private List<UserShowing> userShowings;

    public List<UserShowing> getUserShowings() {
        return userShowings;
    }

    public void setUserShowings(List<UserShowing> userShowings) {
        this.userShowings = userShowings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
