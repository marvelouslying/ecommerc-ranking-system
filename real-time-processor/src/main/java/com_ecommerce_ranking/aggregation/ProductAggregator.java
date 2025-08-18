//package com_ecommerce_ranking.aggregation;
//
//import com.demo.ProductMetrics;
//import com.demo.UserBehavior;
//import com.demo.UserBehavior;
//import org.apache.flink.api.common.functions.AggregateFunction;
//
//import java.time.Instant;
//
//public class ProductAggregator implements AggregateFunction<UserBehavior, ProductAccumulator, ProductMetrics> {
//
//    @Override
//    public ProductAccumulator createAccumulator() {
//        return new ProductAccumulator();
//    }
//
//    @Override
//    public ProductAccumulator add(UserBehavior behavior, ProductAccumulator acc) {
//        acc.setProductId(behavior.getProductId());
//        switch (behavior.getBehavior()) {
//            case "view": acc.incrementViews(); break;
//            case "click": acc.incrementClicks(); break;
//            case "add_to_cart": acc.incrementCartAdds(); break;
//            case "purchase": acc.incrementPurchases(); break;
//            case "repeat_purchase": acc.incrementRepeatPurchases(); break;
//        }
//        return acc;
//    }
//
//    @Override
//    public ProductMetrics getResult(ProductAccumulator acc) {
//        return new ProductMetrics(
//                acc.getProductId(),
//                Instant.now(),
//                acc.getViews(),
//                acc.getClicks(),
//                acc.getCartAdds(),
//                acc.getPurchases(),
//                acc.getRepeatPurchases()
//        );
//    }
//
//    @Override
//    public ProductAccumulator merge(ProductAccumulator a, ProductAccumulator b) {
//        a.merge(b);
//        return a;
//    }
//
//    public static class ProductAccumulator {
//        private String productId;
//        private long views = 0;
//        private long clicks = 0;
//        private long cartAdds = 0;
//        private long purchases = 0;
//        private long repeatPurchases = 0;
//
//        // 各种increment方法和merge方法...
//    }
//}
