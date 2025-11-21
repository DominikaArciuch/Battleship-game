export type Position = [number, number];
export interface ShipType {
    size: number;
    positions: Position[];
    sunk: boolean;
}