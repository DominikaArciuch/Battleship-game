import type {CreateGameRequest, CreateGameResponse} from "../types/game.tsx";

export async function createGame(name: string): Promise<CreateGameResponse> {
    const requestData: CreateGameRequest = {name: name};
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