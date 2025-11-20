import type {Cell} from "./cell.tsx";
import type {Ship} from "./ship.tsx";

export interface Board {
    width: number;
    height: number;
    cells: Cell[];
    ships: Ship[];
}
