import {useState} from "react";
import {Box, Button, TextField, Typography} from "@mui/material";
import {createGame} from "../api/gameApi.tsx";
import { useGame } from "../context/GameContext.tsx";


export function Intro() {
    const [name, setName] = useState("");
    const [loading, setLoading] = useState(false);
    const { setGame } = useGame();

    async function handleSubmit(name: string) {
        try {
            setLoading(true);
            const game = await createGame(name);
            setGame(game);
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
            sx={{
                backgroundColor: "#262978",
                padding: "1rem",
            }}
        >
            <Typography variant="h3" fontWeight={700}>
                Battleship
            </Typography>

            <TextField
                label="Twoje imię"
                value={name}
                onChange={(e) => setName(e.target.value)}
                variant="outlined"
                sx={{width: 300}}
            />

            <Button
                variant="contained"
                disabled={!name.trim() || loading}
                onClick={() => handleSubmit(name)}
                sx={{width: 200}}
            >
                {loading ? "Loading..." : "Start Game"}
            </Button>
        </Box>
    );
}
