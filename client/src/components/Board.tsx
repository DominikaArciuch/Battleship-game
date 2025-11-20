import { Box } from "@mui/material";
import { motion } from "framer-motion";

const MotionBox = motion.create(Box);

const GRID_SIZE = 10;

export function Board() {
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
            {Array.from({ length: GRID_SIZE * GRID_SIZE }).map((_, i) => (
                <MotionBox
                    key={i}
                    border="1px solid #64b5f6"
                    sx={{
                        backgroundColor: "#e3f2fd",
                        cursor: "pointer"
                    }}
                    whileHover={{ scale: 1.1, backgroundColor: "#63b3ed" }}
                    whileTap={{ scale: 0.9, backgroundColor: "#3182ce" }}
                />
            ))}
        </Box>
    );
}
