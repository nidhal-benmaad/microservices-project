package com.example.gestionarticlesstockdistribues.dto;

import com.example.gestionarticlesstockdistribues.entities.Article;
import lombok.Builder;

@Builder
    public record ArticleDTO(long id, String name, StockDTO stockDTO) {
    public static Article mapToEntity(ArticleDTO articleDTO){
        return Article.builder()
                .idArticle(articleDTO.id)
                .nameArticle(articleDTO.name)
                .build();

    }
    public static ArticleDTO mapToDTO(Article article){
        return  ArticleDTO.builder()
                .id(article.getIdArticle())
                .name(article.getNameArticle())
                .build();
    }



}
