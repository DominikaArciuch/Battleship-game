import { useState } from "react";
import { Box, Button, TextField, Typography } from "@mui/material";


interface IntroProps {
    onStart: (playerName: string) => void;
}

export function Intro({ onStart }: IntroProps) {
    const [name, setName] = useState("");

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
                sx={{ width: 300 }}
            />

            <Button
                variant="contained"
                disabled={!name.trim()}
                onClick={() => onStart(name)}
                sx={{ width: 200 }}
            >
                Join game
            </Button>
        </Box>
    );
}
