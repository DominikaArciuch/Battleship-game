package com.arciuch.backend.dto;
import java.util.List;

public record PlaceShipsRequest (
        String playerId,
        List<int[]> occupiedCells
) {}
