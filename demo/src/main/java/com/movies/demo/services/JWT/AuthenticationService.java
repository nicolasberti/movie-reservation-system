package com.movies.demo.services.JWT;

import com.movies.demo.dtos.AuthenticationResponse;
import com.movies.demo.dtos.LoginUserDTO;
import com.movies.demo.dtos.RegisterUserDTO;
import com.movies.demo.models.Role;
import com.movies.demo.models.User;
import com.movies.demo.models.exceptions.InvalidRequestException;
import com.movies.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterUserDTO request) {
        if(userRepository.existsByEmail(request.getEmail()))
            throw new InvalidRequestException("Email already exists", 409);
        User user = User.builder().
                    name(request.getName()).
                    email(request.getEmail()).
                    password(passwordEncoder.encode(request.getPassword())).
                    role(Role.USER).
                    build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(LoginUserDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}