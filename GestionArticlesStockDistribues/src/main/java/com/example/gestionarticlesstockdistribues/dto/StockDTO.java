package com.example.gestionarticlesstockdistribues.dto;

import lombok.Builder;

@Builder
public record StockDTO(long id, String nameStock) {
}
