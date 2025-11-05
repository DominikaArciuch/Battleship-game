package com.arciuch.backend.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ShipDto (
    int size,
    List<CellDto> cells,
    boolean sunk
){
}
