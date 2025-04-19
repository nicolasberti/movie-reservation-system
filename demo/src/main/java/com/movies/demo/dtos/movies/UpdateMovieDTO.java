package com.movies.demo.dtos.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMovieDTO {

    private String name;
    private String description;
    private String image;
    private String gender;
}
