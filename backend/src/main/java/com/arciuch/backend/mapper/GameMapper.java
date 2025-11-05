package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.GameDto;
import com.arciuch.backend.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {
    final PlayerMapper playerMapper;

    public Game toGame(GameDto gameDto) {
        return Game.builder()
                .player1(playerMapper.toPlayer(gameDto.player1()))
                .player2(playerMapper.toPlayer(gameDto.player2()))
                .currentPlayer(playerMapper.toPlayer(gameDto.currentPlayer()))
                .finished(gameDto.finished())
                .build();
    }

    public GameDto toGameDto(Game game) {
        return GameDto.builder()
                .player1(playerMapper.toPlayerDto(game.getPlayer1()))
                .player2(playerMapper.toPlayerDto(game.getPlayer2()))
                .currentPlayer(playerMapper.toPlayerDto(game.getCurrentPlayer()))
                .finished(game.isFinished())
                .build();
    }
}
