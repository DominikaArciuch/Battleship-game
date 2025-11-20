import {CssBaseline, Container, Box} from "@mui/material";
import {ThemeProvider, createTheme} from "@mui/material/styles";
import {Intro} from "./pages/Intro.tsx";
import {useGame} from "./context/GameContext.tsx";
import {GameView} from "./pages/GameView.tsx";

const theme = createTheme({
    palette: {
        mode: "dark",
        primary: {main: "#88d219"},
    },
});

function App() {
    const {game} = useGame();
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline/>
            <Box
                sx={{
                    minHeight: "100vh",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                }}
            >
                <Container
                    maxWidth="md"
                    sx={{
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        flexDirection: "column",
                    }}
                >
                    {!game ? <Intro/> : <GameView/>}
                </Container>
            </Box>
        </ThemeProvider>
    );
}

export default App;
