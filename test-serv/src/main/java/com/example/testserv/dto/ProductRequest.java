package com.example.testserv.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String race, String color, BigDecimal price, String description, String image) {
}
