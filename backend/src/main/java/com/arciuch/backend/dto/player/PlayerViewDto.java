package com.arciuch.backend.dto.player;

import lombok.Builder;

@Builder
public record PlayerViewDto(
        String name
) {
}
