//package com_ecommerce_ranking.aggregation;
//
//import com.demo.ProductMetrics;
//import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
//import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
//import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;
//
//public class RedisSink implements RedisMapper<ProductMetrics> {
//
//    @Override
//    public RedisCommandDescription getCommandDescription() {
//        return new RedisCommandDescription(RedisCommand.HSET, "product_metrics");
//    }
//
//    @Override
//    public String getKeyFromData(ProductMetrics data) {
//        return data.getProductId();
//    }
//
//    @Override
//    public String getValueFromData(ProductMetrics data) {
//        return String.format("%d,%d,%d,%d,%d,%d",
//                data.getTimestamp().toEpochMilli(),
//                data.getViews(),
//                data.getClicks(),
//                data.getCartAdds(),
//                data.getPurchases(),
//                data.getRepeatPurchases());
//    }
//}
