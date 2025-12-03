import type {PlaceShipErrorResponse, PlaceShipsResponse, PlaceShipsSuccessResponse} from "./types/shipType.tsx";

export function isSuccessResponse(
    response: PlaceShipsResponse
): response is PlaceShipsSuccessResponse {
    return response.success;
}

export function isErrorResponse(
    response: PlaceShipsResponse
): response is PlaceShipErrorResponse {
    return !response.success;
}