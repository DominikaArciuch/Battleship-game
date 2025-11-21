package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.player.CreatePlayer;
import com.arciuch.backend.dto.player.PlayerDto;
import com.arciuch.backend.dto.player.PlayerViewDto;
import com.arciuch.backend.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMapper {
    final BoardMapper boardMapper;
    private Integer playersAmount = 0;

    public PlayerDto toPlayerDto(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .board(boardMapper.toBoardDto(player.getBoard()))
                .build();
    }

    public Player toPlayer(CreatePlayer createPlayer) {
        playersAmount++;
        return Player.builder()
//                .id(UUID.randomUUID().toString())
                .id(playersAmount.toString())
                .name(createPlayer.name())
                .build();
    }

    public PlayerViewDto toPlayerViewDto(Player player) {
        return  PlayerViewDto.builder()
                .name(player.getName())
                .build();
    }
}
