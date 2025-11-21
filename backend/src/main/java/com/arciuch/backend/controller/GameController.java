package com.arciuch.backend.controller;

import com.arciuch.backend.dto.player.CreatePlayer;
import com.arciuch.backend.dto.GameViewForPlayerDto;
import com.arciuch.backend.dto.player.RequestPlayer;
import com.arciuch.backend.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameViewForPlayerDto> createGame(@RequestBody CreatePlayer player) {
        log.info("Received request with player {} to create new game",player.name());
        val game = gameService.joinGame(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @GetMapping()
    public ResponseEntity<GameViewForPlayerDto> getGameForPlayer(@RequestBody RequestPlayer player) {
        log.info("Received request with playerId {} to get game",player.playerId());
        val game = gameService.getGameForPlayer(player.playerId());
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }
}
