package com.example.stockservice.controllers;

import com.example.stockservice.dto.ArticleDto;
import com.example.stockservice.services.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;

@RestController("api/v1/stock/")
public class StockController {

  private KafkaTemplate<String, String> kafkaTemplate;
  private ArticleService articleService;

  @PostMapping("add/")
  public void addArticle(@RequestBody ArticleDto articleDto){

  }


}
