package com.example.microservicestock.services;

import com.example.microservicestock.dto.StockDTO;
import org.springframework.data.domain.Page;

public interface IStockservice {
    StockDTO addStock(StockDTO stockDTO);
    StockDTO findById(long id);
    Page<StockDTO> findAll(int size, int pagenbr);
    StockDTO updateStock(StockDTO stockDTO);
    void deleteStock(long id);
    void deleteStock(StockDTO stockDTO);

}
