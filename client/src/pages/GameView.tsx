import {useGame} from "../context/GameContext.tsx";
import {GameStates} from "../types/game.tsx";
import {PlacingShipsView} from "./PlacingShipsView.tsx";

export function GameView() {
    const {game} = useGame();

    function page() {
        if (game?.gameState === GameStates.PLACING_SHIPS) {
            return <PlacingShipsView/>
        }
    }

    return (page())
}