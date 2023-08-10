package com.example.classactivity.exceptions;


public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String s) {
        System.out.println("No name");
    }
}

