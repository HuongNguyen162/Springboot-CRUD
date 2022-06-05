package com.example.springproject.exception;

public class DublicateRecordException extends RuntimeException{
    public DublicateRecordException(String message) {
        super(message);
    }
}
