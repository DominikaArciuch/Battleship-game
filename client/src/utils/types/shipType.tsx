export type Position = [number, number];
export interface ShipType {
    size: number;
    positions: Position[];
    sunk: boolean;
}

// --------- REQUESTS ---------
export interface PlaceShipsRequestType {
    playerId: string;
    occupiedCells: Position[];
}

//--------- RESPONSES ---------
export interface PlaceShipErrorResponse {
    success: false;
    message: string;
}

export interface PlaceShipsSuccessResponse {
    success: true;
}

export type PlaceShipsResponse =
    | PlaceShipsSuccessResponse
    | PlaceShipErrorResponse