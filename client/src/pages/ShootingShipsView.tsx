import {Board} from "../components/Board.tsx";
import {Box, Button, Typography} from "@mui/material";
import {useGame} from "../context/GameContext.tsx";
import {useState} from "react";
import type {BoardType} from "../utils/types/boardType.tsx";

export function ShootingShipsView() {
    const {game} = useGame();
    const [board, setBoard] = useState<BoardType>(game!.activePlayer.board);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    function handleShotShip() {
        console.log("handleShotShip");
    }

    async function handleSave() {
        try {
            setLoading(true);
            setError(null);
            // Placeholder for saving shooting action
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
            <Box display="flex" gap={4} flexDirection="row">
                <Box gap={2} display="flex" flexDirection="column" justifyContent="center" alignItems="center">
                    <Typography variant="h5" component="div">
                        Your ships
                    </Typography>
                <Board board={board} handleClick={handleShotShip} disabled={true}/>
                </Box>
                <Box gap={2} display="flex" flexDirection="column" justifyContent="center" alignItems="center">
                    <Typography variant="h5" component="div">
                        Opponent ships
                    </Typography>
                <Board board={board} handleClick={handleShotShip}/>
                </Box>
            </Box>
            <Button
                variant="contained"
                disabled={loading}
                onClick={() => handleSave()}
                sx={{width: 200}}
            >
                {loading ? "Loading..." : "Shoot"}
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
    );
}