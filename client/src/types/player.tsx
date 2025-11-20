import type {Board} from "./board.tsx";

export interface Player {
    id?: string;
    name: string;
    board?: Board;
}


