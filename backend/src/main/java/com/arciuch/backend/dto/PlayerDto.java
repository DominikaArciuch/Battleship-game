package com.arciuch.backend.dto;

import lombok.Builder;

@Builder
public record PlayerDto (
    int id,
    String name,
    BoardDto board
) {

}
