package com_ecommerce_ranking.model;

public class ProductRank {
    private String productId;
    private double score;

    public ProductRank() {}

    public ProductRank(String productId, double score) {
        this.productId = productId;
        this.score = score;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
