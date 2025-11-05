package com.arciuch.backend.dto;

import lombok.Builder;

@Builder
public record GameDto (
    PlayerDto player1,
    PlayerDto player2,
    PlayerDto currentPlayer,
    boolean finished
) {
}
