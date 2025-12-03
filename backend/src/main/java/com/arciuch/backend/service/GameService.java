package com.arciuch.backend.service;

import com.arciuch.backend.dto.PlaceShipsRequest;
import com.arciuch.backend.dto.player.CreatePlayer;
import com.arciuch.backend.dto.GameViewForPlayerDto;
import com.arciuch.backend.enums.CellState;
import com.arciuch.backend.enums.GameState;
import com.arciuch.backend.exception.ShipPlacementException;
import com.arciuch.backend.factory.BoardFactory;
import com.arciuch.backend.factory.PlayerFactory;
import com.arciuch.backend.mapper.GameMapper;
import com.arciuch.backend.model.*;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GameService {
    final private int boardWidth = 10;
    final private int boardHeight = 10;
    final private GameMapper gameMapper;
    private final Game currentGame = Game.builder()
            .finished(false)
            .gameState(GameState.WAITING_FOR_PLAYER)
            .build();
    private final PlayerFactory playerFactory;
    private final BoardFactory boardFactory;
    List<Player> waitingPlayers = new ArrayList<>();

    public GameViewForPlayerDto joinGame(CreatePlayer createPlayer) {
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

    public GameViewForPlayerDto placeShips(PlaceShipsRequest placeShipsRequest) {
        val player = currentGame.getPlayer1().getId().equals(placeShipsRequest.playerId())
                ? currentGame.getPlayer1() : currentGame.getPlayer2();

        List<Cell> cells = placeShipsRequest.occupiedCells().stream().map(c -> new Cell(c[0], c[1], CellState.SHIP)).toList();
        val ships = groupShips(cells);
        validateShipPlacement(ships);
        putShipsOnBoard(player, ships);
        return gameMapper.toGameViewForPlayerDto(currentGame, player.getId());
    }

    private void putShipsOnBoard(Player player, List<Ship> ships) {
        val newBoard = boardFactory.createBoard(boardWidth, boardHeight);
        for (Ship ship : ships) {
            val occupiedCells = newBoard.getCells().stream().filter(c -> c.getState() == CellState.SHIP).toList();
            for (Cell cell : ship.getCells()) {
                isCellAdjacent(cell, occupiedCells);
                newBoard.getCells().stream()
                        .filter(c -> c.getX() == cell.getX() && c.getY() == cell.getY() && c.getState() == CellState.EMPTY)
                        .findFirst()
                        .ifPresent(c -> c.setState(CellState.SHIP));
            }
        }
        player.setBoard(newBoard);
    }

    private void isCellAdjacent(Cell shipCell, List<Cell> occupiedCells) {
        occupiedCells.stream().filter(c -> c != shipCell).forEach(c -> {
            if (Math.abs(c.getX() - shipCell.getX()) <= 1 && Math.abs(c.getY() - shipCell.getY()) <= 1) {
                throw new ShipPlacementException(
                        "Invalid ship placement at cell",
                        shipCell.getX(),
                        shipCell.getY()
                );
            }
        });
    }

    private List<Ship> groupShips(List<Cell> occupiedCells) {
        List<Ship> ships = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();

        for (Cell cell : occupiedCells) {
            if (!visited.contains(cell)) {
                Ship ship = new Ship();
                Queue<Cell> queue = new LinkedList<>();
                queue.add(cell);

                while (!queue.isEmpty()) {
                    Cell c = queue.poll();
                    if (occupiedCells.contains(c) && visited.add(c)) {
                        ship.getCells().add(c);

                        queue.add(new Cell(c.getX() + 1, c.getY(), CellState.SHIP));
                        queue.add(new Cell(c.getX() - 1, c.getY(), CellState.SHIP));
                        queue.add(new Cell(c.getX(), c.getY() + 1, CellState.SHIP));
                        queue.add(new Cell(c.getX(), c.getY() - 1, CellState.SHIP));
                    }
                }
                ships.add(ship);
            }
        }
        return ships;
    }

    private void validateShipPlacement(List<Ship> ships) {
        for (Ship ship : ships) {
            for (Cell cell : ship.getCells()) {
                if (!validateCellPlacement(cell)) {
                    throw new ShipPlacementException(
                            "Invalid ship placement at cell",
                            cell.getX(),
                            cell.getY()
                    );
                }
            }
        }
    }


    private boolean validateCellPlacement(Cell cell) {
        return cell.getX() >= 0 && cell.getX() <= boardWidth && cell.getY() >= 0 && cell.getY() <= boardHeight;
    }

    private boolean validateShipSize(Ship ship) {
        int size = ship.getCells().size();
        return size == 2 || size == 3 || size == 4 || size == 5;
    }
}
