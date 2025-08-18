//package com_ecommerce_ranking.controller;
//
//import com.ecommerce.ranking.model.ProductRank;
//import com.ecommerce.ranking.service.RankingService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class RankingController {
//
//    private final RankingService rankingService;
//
//    public RankingController(RankingService rankingService) {
//        this.rankingService = rankingService;
//    }
//
//    @GetMapping("/top-products")
//    public List<ProductRank> getTopProducts(
//            @RequestParam(defaultValue = "100") int top) {
//        return rankingService.getTopProducts(top);
//    }
//}
