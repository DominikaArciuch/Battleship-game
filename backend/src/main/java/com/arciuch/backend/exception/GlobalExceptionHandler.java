package com.arciuch.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    record ErrorResponse(String message, int x, int y) {}

    @ExceptionHandler(ShipPlacementException.class)
    public ResponseEntity<?> handleShipOutOfBoardException(ShipPlacementException e) {
        var error = new ErrorResponse(
                e.getMessage(),
                e.getX(),
                e.getY()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
