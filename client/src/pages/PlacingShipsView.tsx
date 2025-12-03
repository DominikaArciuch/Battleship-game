import {Board} from "../components/Board.tsx";
import {useGame} from "../context/GameContext.tsx";
import {useState} from "react";
import type {BoardType} from "../utils/types/boardType.tsx";
import {CellStateType, type CellType} from "../utils/types/cellType.tsx";
import {Box, Button} from "@mui/material";
import {placeShipsApi} from "../api/gameApi.tsx";
import type {Position} from "../utils/types/shipType.tsx";
import {isErrorResponse, isSuccessResponse} from "../utils/typeGuards.tsx";

export function PlacingShipsView() {
    const {game} = useGame();
    const [board, setBoard] = useState<BoardType>(game!.activePlayer.board);
    const [loading, setLoading] = useState(false);
    const [shipList, setShipList] = useState<Position[]>([]);
    const [error, setError] = useState<string | null>(null);

    function handlePlacingShip(cell: CellType) {
        const newState = cell.state === CellStateType.SHIP ? CellStateType.EMPTY : CellStateType.SHIP;
        const updatedCells: CellType[] = board.cells.map(c =>
            c.x === cell.x && c.y === cell.y ? {...c, state: newState} : c
        );

        if (newState === CellStateType.SHIP) {
            setShipList([...shipList, [cell.x, cell.y]])
        } else {
            setShipList(shipList.filter(pos => !(pos[0] === cell.x && pos[1] === cell.y)));
        }

        setBoard({
            ...board,
            cells: updatedCells,
        });
    }

    async function handleSave() {
        try {
            setLoading(true);
            setError(null);
            const response = await placeShipsApi(shipList, game!.activePlayer.id);
            if (isSuccessResponse(response)) {
                console.log("Ships placed successfully");
            } else if (isErrorResponse(response)) {
                setError(response.message);
            }
        } catch (error) {
            console.error(error);
        } finally {
            setLoading(false);
        }
    }

    return (
        <Box
            display="flex"
            flexDirection="column"
            justifyContent="center"
            alignItems="center"
            gap={4}
        >
            <Board board={board} handleClick={handlePlacingShip}/>
            <Button
                variant="contained"
                disabled={loading}
                onClick={() => handleSave()}
                sx={{width: 200}}
            >
                {loading ? "Loading..." : "Save"}
            </Button>
            <Box
                sx={{
                    minHeight: "24px",
                    color: "red",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                }}
            >
                {error}
            </Box>

        </Box>
    )
}