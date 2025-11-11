package com.arciuch.backend.factory;

import com.arciuch.backend.dto.CreatePlayer;
import com.arciuch.backend.mapper.PlayerMapper;
import com.arciuch.backend.model.Player;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerFactory {
    private final PlayerMapper playerMapper;
    private final BoardFactory boardFactory;
    public Player createPlayer(CreatePlayer createPlayer) {
        val player = playerMapper.toPlayer(createPlayer);
        val board = boardFactory.createBoard(10, 10);
        player.setBoard(board);
        return  player;
    }
}
