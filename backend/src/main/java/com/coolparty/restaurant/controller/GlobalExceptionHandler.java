package com.coolparty.restaurant.controller;

import com.coolparty.restaurant.error.EmailIsUsedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailIsUsedException.class)
    public ResponseEntity<Object> emailIsUsedException() {
        return new ResponseEntity<>(
                "Такий е-mail вже зареєстровано!",
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> noSuchElementException() {
        return new ResponseEntity<>(
                "Не знайдено елементів відповідно до критеріїв!",
                HttpStatus.FORBIDDEN);
    }
}
