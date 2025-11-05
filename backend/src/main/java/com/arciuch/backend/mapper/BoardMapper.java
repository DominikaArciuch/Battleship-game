package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.BoardDto;
import com.arciuch.backend.dto.BoardViewDto;
import com.arciuch.backend.dto.CellDto;
import com.arciuch.backend.enums.CellState;
import com.arciuch.backend.model.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public BoardDto toBoardDto(Board board) {
        return BoardDto.builder()
                .width(board.getWidth())
                .height(board.getHeight())
                .cells(board.getCells().stream().map(CellMapper::toCellDto).toList())
                .ships(board.getShips().stream().map(ShipMapper::toShipDto).toList())
                .build();
    }

    public BoardViewDto toViewDto(Board board) {
        return BoardViewDto.builder()
                .width(board.getWidth())
                .height(board.getHeight())
                .cells(board.getCells().stream().map(cell ->
                        CellDto.builder()
                                .x(cell.getX())
                                .y(cell.getY())
                                .state(cell.getState() == CellState.SHIP ? CellState.EMPTY : cell.getState())
                                .build()
                ).toList())
                .build();
    }

    public Board toBoard(BoardDto boardDto) {
        return Board.builder()
                .width(boardDto.width())
                .height(boardDto.height())
                .cells(boardDto.cells().stream().map(CellMapper::toCell).toList())
                .ships(boardDto.ships().stream().map(ShipMapper::toShip).toList())
                .build();
    }


}
