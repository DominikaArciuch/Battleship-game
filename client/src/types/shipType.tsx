import type {CellType} from "./cellType.tsx";


export interface ShipType {
    size: number;
    cells: CellType[];
    sunk: boolean;
}