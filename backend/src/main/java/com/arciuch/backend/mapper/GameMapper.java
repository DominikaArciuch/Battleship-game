package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.GameDto;
import com.arciuch.backend.dto.GameViewForPlayerDto;
import com.arciuch.backend.model.Game;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {
    final PlayerMapper playerMapper;

    public GameDto toGameDto(Game game) {
        return GameDto.builder()
                .player1(playerMapper.toPlayerDto(game.getPlayer1()))
                .player2(playerMapper.toPlayerDto(game.getPlayer2()))
                .currentPlayer(playerMapper.toPlayerViewDto(game.getCurrentPlayer()))
                .gameState(game.getGameState())
                .finished(game.isFinished())
                .build();
    }

    public GameViewForPlayerDto toGameViewForPlayerDto(Game game, String requestingPlayerId) {
        val active = game.getPlayer1().getId().equals(requestingPlayerId)
                ? game.getPlayer1()
                : game.getPlayer2();
        val opponent = active == game.getPlayer1() ? game.getPlayer2() : game.getPlayer1();
        val opponentView = opponent != null ? playerMapper.toPlayerViewDto(opponent) : null;

        return GameViewForPlayerDto.builder()
                .activePlayer(playerMapper.toPlayerDto(active))
                .opponentPlayer(opponentView)
                .currentPlayer(playerMapper.toPlayerViewDto(game.getCurrentPlayer()))
                .gameState(game.getGameState())
                .finished(game.isFinished())
                .build();

    }

}
