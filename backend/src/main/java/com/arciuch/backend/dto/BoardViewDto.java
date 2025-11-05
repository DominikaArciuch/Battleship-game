package com.arciuch.backend.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BoardViewDto(
        int width,
        int height,
        List<CellDto> cells
) {
}
