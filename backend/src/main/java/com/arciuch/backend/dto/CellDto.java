package com.arciuch.backend.dto;

import com.arciuch.backend.enums.CellState;
import lombok.Builder;

@Builder
public record CellDto(
    int x,
    int y,
    CellState state
) {
}
