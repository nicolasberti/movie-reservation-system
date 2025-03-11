package com.movies.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.demo.models.Showing;
import com.movies.demo.models.User;
import com.movies.demo.models.UserShowing;

@Repository
public interface UserShowingRepository extends JpaRepository<UserShowing, Long> {
    boolean existsByShowingAndSeat(Showing showing, int seat);
    List<UserShowing> findByShowingAndUser(Showing showing, User user);
    List<UserShowing> findByShowing(Showing showing);
}
