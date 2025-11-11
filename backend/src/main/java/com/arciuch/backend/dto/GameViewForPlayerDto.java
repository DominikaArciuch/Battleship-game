package com.arciuch.backend.dto;

import com.arciuch.backend.enums.GameState;
import lombok.Builder;

@Builder
public record GameViewForPlayerDto(
        PlayerDto activePlayer,
        PlayerViewDto opponentPlayer,
        PlayerViewDto currentPlayer,
        GameState gameState,
        boolean finished
) {
}
