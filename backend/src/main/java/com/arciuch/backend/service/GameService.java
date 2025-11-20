package com.arciuch.backend.service;

import com.arciuch.backend.dto.CreatePlayer;
import com.arciuch.backend.dto.GameViewForPlayerDto;
import com.arciuch.backend.enums.GameState;
import com.arciuch.backend.factory.PlayerFactory;
import com.arciuch.backend.mapper.GameMapper;
import com.arciuch.backend.model.Game;
import com.arciuch.backend.model.Player;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    final private GameMapper gameMapper;
    private final Game currentGame = Game.builder()
            .finished(false)
            .gameState(GameState.WAITING_FOR_PLAYER)
            .build();
    private final PlayerFactory playerFactory;
    List<Player> waitingPlayers = new ArrayList<>();

    public GameViewForPlayerDto joinGame (CreatePlayer createPlayer) {
        val player = playerFactory.createPlayer(createPlayer);
        if (waitingPlayers.size() == 1) {
            currentGame.setPlayer2(player);
            currentGame.setGameState(GameState.PLACING_SHIPS);
            waitingPlayers.clear();
        } else {
            currentGame.setPlayer1(player);
            currentGame.setCurrentPlayer(player);
            waitingPlayers.add(player);
        }
        return gameMapper.toGameViewForPlayerDto(currentGame, player.getId());
    }

    public GameViewForPlayerDto getGameForPlayer(String playerId) {
        // TODO: validate player exits and throw exception
        return gameMapper.toGameViewForPlayerDto(currentGame, playerId);
    }


}
