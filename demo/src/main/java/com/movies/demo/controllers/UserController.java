package com.movies.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movies.demo.dtos.UserShowingDTO;
import com.movies.demo.models.User;
import com.movies.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;

    public UserController(
        UserService userService
    ){
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/myshowings")
    public List<UserShowingDTO> getMyShowings(@RequestParam long userId) {
        return userService.getMyShowings(userId)
            .stream()
            .map(us -> new UserShowingDTO(us.getId(), us.getSeat(), us.getShowing()))
            .collect(Collectors.toList());
    }
}
