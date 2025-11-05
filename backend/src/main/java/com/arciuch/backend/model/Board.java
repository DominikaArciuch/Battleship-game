package com.arciuch.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int width = 10;
    private int height = 10;
    private List<Cell> cells;
    private List<Ship> ships;
}
