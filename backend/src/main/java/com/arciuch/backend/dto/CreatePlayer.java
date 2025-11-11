package com.arciuch.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePlayer(
        @NotBlank(message = "Name must not be empty")
        String name
) {
}
