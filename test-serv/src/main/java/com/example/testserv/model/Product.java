package com.example.testserv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document("value = product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    // Our products are cats
    @Id
    private String id;
    private String name;
    private String race;
    private String color;
    private BigDecimal price;
    private String description;
    private String image; // URL
}
