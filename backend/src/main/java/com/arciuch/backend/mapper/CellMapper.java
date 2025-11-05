package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.CellDto;
import com.arciuch.backend.model.Cell;

public class CellMapper {

    public static CellDto toCellDto(Cell cell) {
        return CellDto.builder()
                .x(cell.getX())
                .y(cell.getY())
                .state(cell.getState())
                .build();
    }

    public static Cell toCell(CellDto cellDto) {
        return Cell.builder()
                .x(cellDto.x())
                .y(cellDto.y())
                .state(cellDto.state())
                .build();
    }
}
