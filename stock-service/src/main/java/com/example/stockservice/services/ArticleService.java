package com.example.stockservice.services;

import com.example.stockservice.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto createArticle(ArticleDto articleDto);
    List<ArticleDto> getAllArticles();
    ArticleDto getArticleById(int id);
    ArticleDto updateArticle(ArticleDto articleDto);
    void deleteArticle(int id);

}
