package com.arciuch.backend.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BoardDto(
        int width,
        int height,
        List<CellDto> cells,
        List<ShipDto> ships
) {
}
