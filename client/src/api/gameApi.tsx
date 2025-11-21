import type {CreateGameRequestType, CreateGameResponseType} from "../types/gameType.tsx";
import type {BoardType} from "../types/boardType.tsx";

export async function createGameApi(name: string): Promise<CreateGameResponseType> {
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

export async function placeShipsApi(board: BoardType, playerId: string) {
    const requestData = {
        board: board,
        playerId: playerId,
    }
    console.log(requestData);
}