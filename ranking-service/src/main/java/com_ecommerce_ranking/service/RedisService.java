//package com_ecommerce_ranking.service;
//
//import com.ecommerce.ranking.model.ProductMetrics;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class RedisService {
//
//    private final RedisTemplate<String, String> redisTemplate;
//    private HashOperations<String, String, String> hashOperations;
//
//    private static final String METRICS_KEY = "product_metrics";
//
//    public RedisService(RedisTemplate<String, String> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @PostConstruct
//    private void init() {
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//    public Map<String, ProductMetrics> getAllProductMetrics() {
//        Map<String, String> entries = hashOperations.entries(METRICS_KEY);
//        Map<String, ProductMetrics> metricsMap = new HashMap<>();
//
//        entries.forEach((productId, data) -> {
//            String[] parts = data.split(",");
//            if (parts.length == 6) {
//                ProductMetrics metrics = new ProductMetrics(
//                        productId,
//                        Long.parseLong(parts[0]),
//                        Long.parseLong(parts[1]),
//                        Long.parseLong(parts[2]),
//                        Long.parseLong(parts[3]),
//                        Long.parseLong(parts[4]),
//                        Long.parseLong(parts[5])
//                );
//                metricsMap.put(productId, metrics);
//            }
//        });
//
//        return metricsMap;
//    }
//}
