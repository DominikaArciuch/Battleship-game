package com.arciuch.backend.exception;

import lombok.Getter;

@Getter
public class ShipPlacementException extends RuntimeException {
    private final int x;
    private final int y;

    public ShipPlacementException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
