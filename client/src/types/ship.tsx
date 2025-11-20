import type {Cell} from "./cell.tsx";


export interface Ship {
    size: number;
    cells: Cell[];
    sunk: boolean;
}