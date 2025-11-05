package com.arciuch.backend.model;

import com.arciuch.backend.enums.CellState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cell {
    private int x;
    private int y;
    private CellState state;
}
