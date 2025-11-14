import { CssBaseline, Container, Box } from "@mui/material";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import { Board } from "./components/Board.tsx";
import { useState } from "react";
import { Intro } from "./pages/Intro.tsx";

const theme = createTheme({
    palette: {
        mode: "dark",
        primary: { main: "#88d219" },
    },
});

function App() {
    const [playerName, setPlayerName] = useState<string | null>(null);

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />

            {/* 🔥 Fullscreen flex layout */}
            <Box
                sx={{
                    minHeight: "100vh",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                }}
            >
                {/* 🔥 This container is now centered */}
                <Container
                    maxWidth="md"
                    sx={{
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        flexDirection: "column",
                    }}
                >
                    {!playerName ? <Intro onStart={setPlayerName} /> : <Board />}
                </Container>
            </Box>
        </ThemeProvider>
    );
}

export default App;
