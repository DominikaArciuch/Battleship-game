import {Board} from "../components/Board.tsx";
import {useGame} from "../context/GameContext.tsx";
import {useState} from "react";
import type {BoardType} from "../types/boardType.tsx";
import {CellStateType, type CellType} from "../types/cellType.tsx";
import {Box, Button} from "@mui/material";
import {placeShipsApi} from "../api/gameApi.tsx";

export function PlacingShipsView() {
    const {game} = useGame();
    const [board, setBoard] = useState<BoardType>(game!.activePlayer.board);
    const [loading, setLoading] = useState(false);

    function handlePlacingShip(cell: CellType) {
        const newState = cell.state === CellStateType.SHIP ? CellStateType.EMPTY : CellStateType.SHIP;
        const updatedCells: CellType[] = board.cells.map(c =>
            c.x === cell.x && c.y === cell.y ? {...c, state: newState} : c
        );
        setBoard({
            ...board,
            cells: updatedCells,
        });
    }

    async function handleSave() {
        try {
            setLoading(true);
            await placeShipsApi(board, game!.activePlayer.id);
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
        </Box>
    )
}