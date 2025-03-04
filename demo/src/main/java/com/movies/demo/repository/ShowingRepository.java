package com.movies.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.demo.models.Movie;
import com.movies.demo.models.Showing;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Long> {
    List<Showing> findByDate(Date date);

    List<Showing> findByMovieAndDate(Movie movie, Date date);
}
