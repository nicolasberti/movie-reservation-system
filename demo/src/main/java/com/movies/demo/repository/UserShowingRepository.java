package com.movies.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.demo.models.UserShowing;

@Repository
public interface UserShowingRepository extends JpaRepository<UserShowing, Long> {
}
