package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.PlayerDto;
import com.arciuch.backend.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMapper {
    final BoardMapper boardMapper;
    public PlayerDto toPlayerDto(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .board(boardMapper.toBoardDto(player.getBoard()))
                .build();
    }

    public Player toPlayer(PlayerDto playerDto) {
        return Player.builder()
                .id(playerDto.id())
                .name(playerDto.name())
                .board(boardMapper.toBoard(playerDto.board()))
                .build();
    }
}
