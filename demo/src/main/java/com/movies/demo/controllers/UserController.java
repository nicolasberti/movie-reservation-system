package com.movies.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movies.demo.dtos.UserShowingDTO;
import com.movies.demo.models.User;
import com.movies.demo.services.UserService;
import com.movies.demo.services.JWT.JwtService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;
    private JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService){
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/myshowings")
    public List<UserShowingDTO> getMyShowings(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        String jwtToken = extractJwtToken(authorizationHeader);
        String email = jwtService.getEmailFromToken(jwtToken);
        return userService.getMyShowings(email)
                .stream()
                .map(us -> new UserShowingDTO(us.getId(), us.getSeat(), us.getShowing()))
                .collect(Collectors.toList());
    }

    private String extractJwtToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
