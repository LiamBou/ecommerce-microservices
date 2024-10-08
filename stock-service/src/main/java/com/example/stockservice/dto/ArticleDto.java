package com.example.stockservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ArticleDto {
    @Id
    private Long id;

}
