import type {CreateGameRequestType, GameResponseType} from "../utils/types/gameType.tsx";
import type {PlaceShipsRequestType, PlaceShipsResponse, Position} from "../utils/types/shipType.tsx";

export async function createGameApi(name: string): Promise<GameResponseType> {
    const requestData: CreateGameRequestType = {name: name};
    const response = await fetch("http://localhost:8080/api/game", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
    });

    if (!response.ok) {
        throw new Error("Failed to create game");
    }

    return response.json();
}

export async function placeShipsApi(ships: Position[], playerId: string): Promise<PlaceShipsResponse> {
    const requestData: PlaceShipsRequestType = {
        playerId: playerId,
        occupiedCells: ships,
    }
    try {
        const response = await fetch("http://localhost:8080/api/game/ships", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestData),
        });
        const data = await response.json();

        if (response.ok) {
            return {
                success: true
            };
        }

        if (response.status === 400) {
            return {
                success: false,
                message: data.message || "Invalid ship placement",
            };
        }

        return {
            success: false,
            message: data.message || "Failed to place ships",
        };

    } catch (error) {
        throw error;
    }
}