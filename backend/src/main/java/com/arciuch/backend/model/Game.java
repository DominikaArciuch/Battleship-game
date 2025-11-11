package com.arciuch.backend.model;

import com.arciuch.backend.enums.GameState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameState gameState;
    private boolean finished = false;
}
