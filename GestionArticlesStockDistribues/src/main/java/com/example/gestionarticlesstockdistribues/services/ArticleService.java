package com.example.gestionarticlesstockdistribues.services;

import com.example.gestionarticlesstockdistribues.dto.ArticleDTO;
import com.example.gestionarticlesstockdistribues.dto.StockDTO;
import com.example.gestionarticlesstockdistribues.entities.Article;
import com.example.gestionarticlesstockdistribues.repositories.ArticleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService implements IArticleservice {

   // @Autowired => on va travailler avec le constructeur
    ArticleRepo articleRepo;
private final IFeignStockService feignStockService;
    @Override
    public ArticleDTO addArticle(ArticleDTO articleDTO) {
        Article article=articleRepo.save(articleDTO.mapToEntity(articleDTO));
        return articleDTO.mapToDTO(article);
    }

    @Override
    public ArticleDTO findById(long id) {
        Article article=articleRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Article found with this id"));
        //à completer getStockid apres pour se connecter au MS stock
        return ArticleDTO.mapToDTO(article) ;
    }

    @Override
    public Page<ArticleDTO> findAll(int size, int pagenbr) {

        return articleRepo.findAll(PageRequest.of(pagenbr,size)).map(ArticleDTO::mapToDTO);
    }

    @Override
    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        Article article=articleRepo.save(articleDTO.mapToEntity(articleDTO));

        return articleDTO.mapToDTO(article);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepo.deleteById(id);


    }

    @Override
    public void deleteArticle(ArticleDTO articleDTO) {

        articleRepo.delete(articleDTO.mapToEntity(articleDTO));

    }

    public ArticleDTO getArticle(Long articleId){
        Optional<Article> article = articleRepo.findById(articleId);
        Long stockId = article.get().getIdStock();
        StockDTO stockDTO = feignStockService.getStockById(stockId);
        ArticleDTO articleDTO = new ArticleDTO(
                article.get().getIdArticle(),
                article.get().getNameArticle(),
                stockDTO
        );
                return articleDTO;
    }
}
