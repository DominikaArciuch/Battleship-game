import type {OpponentType, PlayerType} from "./playerType.tsx";

export const GameStateType = {
    READY_TO_START: "READY_TO_START",
    PLACING_SHIPS: "PLACING_SHIPS",
    IN_PROGRESS: "IN_PROGRESS",
    FINISHED: "FINISHED",
}

export type GameStateType = (typeof GameStateType)[keyof typeof GameStateType];

// --------- REQUESTS ---------

export interface CreateGameRequestType {
    name: string;
}

// --------- RESPONSES ---------

export interface CreateGameResponseType {
    activePlayer: PlayerType;
    opponentPlayer: OpponentType;
    currentPlayer: PlayerType;
    gameState: GameStateType;
    finished: boolean;
}