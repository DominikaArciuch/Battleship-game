import ShipIcon from "@mui/icons-material/SailingRounded";
import CloseIcon from '@mui/icons-material/CloseRounded';
import {Box} from "@mui/material";

export function HitShipIcon() {
    return (
        <Box position="relative" width={24} height={24}>
            <ShipIcon
                sx={{ position: "absolute", top: 0, left: 0 }}
            />
            <CloseIcon
                sx={{ position: "absolute", top: 0, left: 0, color: "red" }}
            />
        </Box>
    );
}