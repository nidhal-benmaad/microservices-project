package com.example.microservicestock.services;


import com.example.microservicestock.dto.ArticleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "article-service", url = "http://localhost:9091/") // Replace with the actual URL
public interface FeignArticleClient {
    @GetMapping("/article/{id}") // Repl
    public ArticleDTO getStockById(@PathVariable Long id);
}
