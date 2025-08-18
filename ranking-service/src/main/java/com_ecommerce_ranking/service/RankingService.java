//package com_ecommerce_ranking.service;
//
//import com.ecommerce.ranking.model.ProductRank;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.stream.Collectors;
//
//@Service
//public class RankingService {
//
//    @Value("${ranking.formula.ctr-weight}") private double ctrWeight;
//    @Value("${ranking.formula.cvr-weight}") private double cvrWeight;
//    @Value("${ranking.formula.repurchase-weight}") private double repurchaseWeight;
//
//    private final RedisService redisService;
//    private final HiveService hiveService;
//
//    public RankingService(RedisService redisService, HiveService hiveService) {
//        this.redisService = redisService;
//        this.hiveService = hiveService;
//    }
//
//    public List<ProductRank> getTopProducts(int topN) {
//        // 获取所有产品的评分
//        Map<String, Double> productScores = calculateAllProductScores();
//
//        // 排序并返回TOP N
//        return productScores.entrySet().stream()
//                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
//                .limit(topN)
//                .map(entry -> new ProductRank(entry.getKey(), entry.getValue()))
//                .collect(Collectors.toList());
//    }
//
//    private Map<String, Double> calculateAllProductScores() {
//        Map<String, ProductMetrics> realtimeMetrics = redisService.getAllProductMetrics();
//        List<HistoricalMetrics> historicalMetrics = hiveService.getYesterdayMetrics();
//
//        Map<String, Double> scores = new ConcurrentHashMap<>();
//
//        historicalMetrics.parallelStream().forEach(historical -> {
//            ProductMetrics realtime = realtimeMetrics.getOrDefault(
//                    historical.getProductId(),
//                    new ProductMetrics(historical.getProductId()));
//
//            double ctr = calculateCTR(historical, realtime);
//            double cvr = calculateCVR(historical, realtime);
//            double repurchaseRate = calculateRepurchaseRate(historical, realtime);
//
//            double score = (ctrWeight * ctr) +
//                    (cvrWeight * cvr) +
//                    (repurchaseWeight * repurchaseRate);
//
//            scores.put(historical.getProductId(), score);
//        });
//
//        return scores;
//    }
//
//    private double calculateCTR(HistoricalMetrics historical, ProductMetrics realtime) {
//        long totalClicks = historical.getClicks() + realtime.getClicks();
//        long totalViews = historical.getViews() + realtime.getViews();
//        return totalViews > 0 ? (double) totalClicks / totalViews : 0;
//    }
//
//    // 类似方法计算CVR和复购率...
//}
