package com.example.microservicestock.controllers;

import com.example.microservicestock.services.IStockservice;
import com.example.microservicestock.dto.StockDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Stocks")
public class stockRestController {
    private  final IStockservice stockRest;
    @PostMapping("addStock")
    StockDTO ajouterStock(@RequestBody StockDTO stockDTO){
        return stockRest.addStock(stockDTO);
    }

    @PutMapping("updateStock")
    StockDTO modifierStock(@RequestBody StockDTO stockDTO){
        return stockRest.updateStock(stockDTO);
    }

    @DeleteMapping("deleteStockById/{id}")
    void deleteStockById(@PathVariable long id){
        stockRest.deleteStock(id);
    }

    @DeleteMapping("deleteStock")
    void deleteArticle(StockDTO stockDTO){
        stockRest.deleteStock(stockDTO);
    }
    @GetMapping("findAllStocks/{size}/{pagenbr}")
    Page<StockDTO> findAll(@PathVariable int size, @PathVariable int pagenbr){
        return stockRest.findAll(size,pagenbr);
    }
    @GetMapping("findOneStockById/{id}")
    StockDTO findById(@PathVariable long id){
        return stockRest.findById(id);
    }








}
