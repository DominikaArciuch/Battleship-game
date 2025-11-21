import {useGame} from "../context/GameContext.tsx";
import {GameStateType} from "../types/gameType.tsx";
import {PlacingShipsView} from "./PlacingShipsView.tsx";

export function GameView() {
    const {game} = useGame();

    function page() {
        if (game?.gameState === GameStateType.PLACING_SHIPS) {
            return <PlacingShipsView/>
        }
        return <PlacingShipsView/>
    }

    return (page())
}