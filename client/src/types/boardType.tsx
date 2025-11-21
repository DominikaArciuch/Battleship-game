import type {CellType} from "./cellType.tsx";
import type {ShipType} from "./shipType.tsx";

export interface BoardType {
    width: number;
    height: number;
    cells: CellType[];
    ships: ShipType[];
}
