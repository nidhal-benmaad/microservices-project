package com.example.gestionarticlesstockdistribues.services;

import com.example.gestionarticlesstockdistribues.dto.ArticleDTO;
import org.springframework.data.domain.Page;

public interface IArticleservice  {
    ArticleDTO addArticle(ArticleDTO articleDTO);
    ArticleDTO findById(long id);
    Page<ArticleDTO> findAll(int size, int pagenbr);
    ArticleDTO updateArticle(ArticleDTO article);
    void deleteArticle(long id);
    void deleteArticle(ArticleDTO articleDTO);
}
