import {Box} from "@mui/material";
import {motion} from "framer-motion";
import type {BoardType} from "../types/boardType.tsx";
import {CellStateType, type CellType} from "../types/cellType.tsx";
import ShipIcon from "@mui/icons-material/SailingRounded";
import {HitShipIcon} from "../icons/HitShipIcon.tsx";

const MotionBox = motion.create(Box);

const GRID_SIZE = 10;

interface BoardProps {
    board: BoardType;
    handleClick: (cell: CellType) => void;
}

export function Board({board, handleClick}: BoardProps) {

    function getCellContent(cell: CellType) {
        switch (cell.state) {
            case CellStateType.SHIP:
                return <ShipIcon />;
            case CellStateType.HIT:
                return <HitShipIcon />;
        }
    }

    return (
        <Box
            display="grid"
            gridTemplateColumns={`repeat(${GRID_SIZE}, 1fr)`}
            width={600}
            height={600}
            gap={0}
            border="2px solid #90caf9"
            borderRadius={2}
            overflow="hidden"
        >
            {board.cells.map((cell, i) => (
                <MotionBox
                    key={i}
                    border="1px solid #64b5f6"
                    sx={{
                        width: 60,
                        height: 60,
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        backgroundColor: "#549fd3",
                        cursor: "pointer"
                    }}
                    whileHover={{scale: 1.1, backgroundColor: "#63b3ed"}}
                    whileTap={{scale: 0.9, backgroundColor: "#3182ce"}}
                    onClick={() => handleClick(cell)}
                >
                    {getCellContent(cell)}
                </MotionBox>

            ))}
        </Box>
    );
}
