import type {BoardType} from "./boardType.tsx";

export interface PlayerType {
    id: string;
    name: string;
    board: BoardType;
}

export interface OpponentType {
    name: string;
}


