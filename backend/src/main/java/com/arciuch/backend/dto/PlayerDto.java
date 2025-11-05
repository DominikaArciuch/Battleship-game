package com.arciuch.backend.dto;

import lombok.Builder;

@Builder
public record PlayerDto (
    String name,
    BoardDto board
) {

}
