import type {Player} from "./player.tsx";

export const GameStates = {
    READY_TO_START: "READY_TO_START",
    PLACING_SHIPS: "PLACING_SHIPS",
    IN_PROGRESS: "IN_PROGRESS",
    FINISHED: "FINISHED",
}

export type GameState = (typeof GameStates)[keyof typeof GameStates];

// --------- REQUESTS ---------

export interface CreateGameRequest {
    name: string;
}

// --------- RESPONSES ---------

export interface CreateGameResponse {
    activePlayer: Player;
    opponentPlayer: Player;
    currentPlayer: Player;
    gameState: GameState;
    finished: boolean;
}