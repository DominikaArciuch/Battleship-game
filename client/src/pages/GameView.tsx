import {useGame} from "../context/GameContext.tsx";
import {GameStateType} from "../utils/types/gameType.tsx";
import {PlacingShipsView} from "./PlacingShipsView.tsx";
import {ShootingShipsView} from "./ShootingShipsView.tsx";

export function GameView() {
    const {game} = useGame();

    function page() {
        // if (game?.gameState === GameStateType.PLACING_SHIPS) {
        //     return <PlacingShipsView/>
        // }
        return <ShootingShipsView/>
    }

    return (page())
}