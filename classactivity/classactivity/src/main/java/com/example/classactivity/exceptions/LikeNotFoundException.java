package com.example.classactivity.exceptions;

public class LikeNotFoundException extends RuntimeException{
    public LikeNotFoundException(String message) {
        super(message);
    }

}
