package com.arciuch.backend.dto.player;

import jakarta.validation.constraints.NotBlank;

public record CreatePlayer(
        @NotBlank(message = "Name must not be empty")
        String name
) {
}
