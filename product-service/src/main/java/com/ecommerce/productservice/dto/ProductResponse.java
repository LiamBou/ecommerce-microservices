package com.ecommerce.productservice.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String race, String color, BigDecimal price, String description, String image) {

}