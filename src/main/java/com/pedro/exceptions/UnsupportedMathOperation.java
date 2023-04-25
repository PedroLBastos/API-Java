package com.pedro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperation extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UnsupportedMathOperation(String s) {
        super(s);
    }
}
