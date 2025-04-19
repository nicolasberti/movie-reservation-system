package com.movies.demo.services;

import java.util.List;

import com.movies.demo.models.User;
import com.movies.demo.models.UserShowing;

public interface UserService {
    public User getUserById(long id);

    public List<User> getAll();

    public List<UserShowing> getMyShowings(String email);
}
