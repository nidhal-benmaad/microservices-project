package com.example.gestionarticlesstockdistribues.services;

import com.example.gestionarticlesstockdistribues.dto.StockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", url = "http://localhost:9091/") // Replace with the actual URL
public interface IFeignStockService {
    @GetMapping("/stock/{id}") // Replace with the actual endpoint
    public StockDTO getStockById(@PathVariable Long id);
}
