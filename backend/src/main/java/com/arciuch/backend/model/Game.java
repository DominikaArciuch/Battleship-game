package com.arciuch.backend.model;

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
    private boolean finished = false;
}
