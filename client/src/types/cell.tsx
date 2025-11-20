export type CellState = "EMPTY" | "SHIP" | "HIT" | "MISS";

export interface Cell {
    x: number;
    y: number;
    state: CellState;
}