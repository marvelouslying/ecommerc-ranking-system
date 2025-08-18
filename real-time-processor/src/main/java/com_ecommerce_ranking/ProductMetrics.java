package com_ecommerce_ranking;

import java.time.Instant;

public class ProductMetrics {
    private String productId;
    private Instant timestamp;
    private long views;
    private long clicks;
    private long cartAdds;
    private long purchases;
    private long repeatPurchases;

    // 构造函数、getters和setters
    public ProductMetrics() {}

    public ProductMetrics(String productId, Instant timestamp, long views,
                          long clicks, long cartAdds, long purchases,
                          long repeatPurchases) {
        this.productId = productId;
        this.timestamp = timestamp;
        this.views = views;
        this.clicks = clicks;
        this.cartAdds = cartAdds;
        this.purchases = purchases;
        this.repeatPurchases = repeatPurchases;
    }

    // 省略getter/setter方法...
}
