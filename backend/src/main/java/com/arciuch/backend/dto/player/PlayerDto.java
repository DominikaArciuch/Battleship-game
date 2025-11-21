package com.arciuch.backend.dto.player;

import com.arciuch.backend.dto.BoardDto;
import lombok.Builder;

@Builder
public record PlayerDto(
        String id,
        String name,
        BoardDto board
) {

}
