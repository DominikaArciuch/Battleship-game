export const CellStateType = {
    EMPTY: "EMPTY",
    SHIP: "SHIP",
    HIT: "HIT",
    MISS: "MISS",
}

export type CellStateType = (typeof CellStateType)[keyof typeof CellStateType];

export interface CellType {
    x: number;
    y: number;
    state: CellStateType;
}