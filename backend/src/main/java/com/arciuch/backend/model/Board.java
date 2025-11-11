package com.arciuch.backend.model;


import com.arciuch.backend.enums.CellState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int width;
    private int height;
    private List<Cell> cells;
    private List<Ship> ships;

    public void boardConfig() {
        createCells();
        ships = new ArrayList<>();
    }
    public void createCells() {
        cells = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells.add(Cell.builder()
                        .x(i)
                        .y(j)
                        .state(CellState.EMPTY)
                        .build());
            }
        }
    }
}
