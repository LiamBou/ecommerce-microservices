package com.example.stockservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ArticleDto {
    private int id;
    private String title;
    private double price;
    private String description;
}