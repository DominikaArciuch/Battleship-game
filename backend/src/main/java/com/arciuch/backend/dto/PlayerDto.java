package com.arciuch.backend.dto;

import lombok.Builder;

@Builder
public record PlayerDto(
        String id,
        String name,
        BoardDto board
) {

}
