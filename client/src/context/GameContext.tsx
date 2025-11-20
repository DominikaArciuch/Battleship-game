// src/context/GameContext.tsx
import {createContext, useContext, useState, type PropsWithChildren} from "react";
import type {CreateGameResponse} from "../types/game.tsx";

interface GameContextValue {
    game: CreateGameResponse | null;
    setGame: (game: CreateGameResponse) => void;
}

const GameContext = createContext<GameContextValue | undefined>(undefined);

export function GameProvider({children}: PropsWithChildren) {
    const [game, setGameState] = useState<CreateGameResponse | null>(() => {
        // const savedGame = localStorage.getItem("game");
        // return savedGame ? JSON.parse(savedGame) : null;
        return null;
    });

    const setGame = (game: CreateGameResponse) => {
        setGameState(game);
        localStorage.setItem("game", JSON.stringify(game));
    };
    return (
        <GameContext.Provider value={{game, setGame}}>
            {children}
        </GameContext.Provider>
    );
}

export function useGame() {
    const context = useContext(GameContext);
    if (!context) {
        throw new Error("useGame must be used within a GameProvider");
    }
    return context;
}
