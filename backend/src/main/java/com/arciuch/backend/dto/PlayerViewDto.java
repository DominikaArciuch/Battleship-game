package com.arciuch.backend.dto;

import lombok.Builder;

@Builder
public record PlayerViewDto(
        String name
) {
}
