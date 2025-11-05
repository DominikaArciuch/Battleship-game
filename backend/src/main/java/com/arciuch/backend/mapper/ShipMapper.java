package com.arciuch.backend.mapper;

import com.arciuch.backend.dto.ShipDto;
import com.arciuch.backend.model.Ship;

public class ShipMapper {
    public static Ship toShip(ShipDto shipDto) {
        return Ship.builder()
                .size(shipDto.size())
                .cells(shipDto.cells().stream().map(CellMapper::toCell).toList())
                .sunk(shipDto.sunk())
                .build();
    }

    public static ShipDto toShipDto(Ship ship) {
        return ShipDto.builder()
                .size(ship.getSize())
                .cells(ship.getCells().stream().map(CellMapper::toCellDto).toList())
                .sunk(ship.isSunk())
                .build();
    }
}
