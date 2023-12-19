package com.example.microservicestock.services;

import com.example.microservicestock.dto.StockDTO;
import com.example.microservicestock.entities.stock;
import com.example.microservicestock.repositories.stockRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class stockService implements IStockservice{

   private final  stockRepo stockRepo;

   private final FeignArticleClient articleClient;

    @Override
    public StockDTO addStock(StockDTO stockDTO) {
        stock stock=stockRepo.save(stockDTO.mapToEntity(stockDTO));
        return stockDTO.mapToDTO(stock);
    }

    @Override
    public StockDTO findById(long id) {
        stock stock=stockRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Stock found with this id"));
        return StockDTO.mapToDTO(stock);
    }

    @Override
    public Page<StockDTO> findAll(int size, int pagenbr) {
        return stockRepo.findAll(PageRequest.of(pagenbr,size)).map(StockDTO::mapToDTO);
    }


    @Override
    public StockDTO updateStock(StockDTO stockDTO) {
        stock stock=stockRepo.save((stockDTO.mapToEntity(stockDTO)));
        return stockDTO.mapToDTO(stock);
    }

    @Override
    public void deleteStock(long id) {
        stockRepo.deleteById(id);

    }

    @Override
    public void deleteStock(StockDTO stockDTO) {
        stockRepo.delete(stockDTO.mapToEntity(stockDTO));

    }
}
