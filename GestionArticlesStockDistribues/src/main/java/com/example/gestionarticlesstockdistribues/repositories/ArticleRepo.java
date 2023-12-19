package com.example.gestionarticlesstockdistribues.repositories;

import com.example.gestionarticlesstockdistribues.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
}
