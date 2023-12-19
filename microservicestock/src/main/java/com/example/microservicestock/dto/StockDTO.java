package com.example.microservicestock.dto;

import com.example.microservicestock.entities.stock;
import lombok.Builder;

@Builder
public record StockDTO(long id, String name) {
    public static stock mapToEntity(StockDTO stockDTO){
        return stock.builder()
                .idStock(stockDTO.id)
                .nameStock(stockDTO.name)
                .build();

    }

    public static StockDTO mapToDTO(stock stock){
        return StockDTO.builder()
                .id(stock.getIdStock())
                .name(stock.getNameStock())
                .build();

    }



}
