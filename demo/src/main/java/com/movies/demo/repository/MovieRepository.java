package com.movies.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.demo.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
