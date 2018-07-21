package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cloie Andrea on 21/07/2018.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException {
    public MyFileNotFoundException(String message) {
        super();
    }

    public MyFileNotFoundException(String message, Throwable cause) {
        super();
    }
}
