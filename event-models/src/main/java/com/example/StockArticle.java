package com.example;

public class StockArticle {
    private final String articleId;
    private final int quantity;

    public StockArticle(String articleId, int quantity) {
        this.articleId = articleId;
        this.quantity = quantity;
    }

    public String getArticleId() {
        return articleId;
    }

    public int getQuantity() {
        return quantity;
    }
}
