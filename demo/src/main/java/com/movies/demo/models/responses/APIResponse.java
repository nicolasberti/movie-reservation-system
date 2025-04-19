package com.movies.demo.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse<T> {
    private T content;

    public APIResponse(T content) {
        this.content = content;
    }
}

