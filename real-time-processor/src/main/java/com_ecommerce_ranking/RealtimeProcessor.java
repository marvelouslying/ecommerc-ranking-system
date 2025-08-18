package com_ecommerce_ranking;
//
import com_ecommerce_ranking.aggregation.RedisSink;
//
import java.time.Duration;
//
public class RealtimeProcessor {
//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.setParallelism(4);
//        env.enableCheckpointing(60000, CheckpointingMode.EXACTLY_ONCE);
//
//        // Kafka消费者配置
//        Properties properties = new Properties();
//        properties.setProperty("bootstrap.servers", "kafka:9092");
//        properties.setProperty("group.id", "realtime-metrics-group");
//
//        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(
//                "user_behavior_topic",
//                new SimpleStringSchema(),
//                properties
//        );
//        consumer.setStartFromLatest();
//
//        // 实时处理流水线
//        DataStream<ProductMetrics> metricsStream = env
//                .addSource(consumer)
//                .map(new JsonToUserBehavior())  // JSON转POJO
//                .assignTimestampsAndWatermarks(
//                        WatermarkStrategy.<UserBehavior>forBoundedOutOfOrderness(Duration.ofSeconds(5))
//                                .withTimestampAssigner((event, timestamp) -> event.getEventTimestamp()))
//                .keyBy(UserBehavior::getProductId)
//                .window(TumblingEventTimeWindows.of(Time.minutes(5)))
//                .aggregate(new ProductAggregator());
//
//        // 写入Redis
//        metricsStream.addSink(new RedisSink());
//
//        // 监控指标输出
//        metricsStream
//                .map(metrics -> new Tuple2<>(metrics.getProductId(), metrics))
//                .addSink(new FlinkMetricsSink());
//
//        env.execute("E-commerce Realtime Metrics Processor");
//    }
//
//    // 产品指标聚合器
//    public static class ProductAggregator
//            implements AggregateFunction<UserBehavior, ProductAccumulator, ProductMetrics> {
//
//        @Override
//        public ProductAccumulator createAccumulator() {
//            return new ProductAccumulator();
//        }
//
//        @Override
//        public ProductAccumulator add(UserBehavior behavior, ProductAccumulator acc) {
//            acc.productId = behavior.getProductId();
//            switch (behavior.getBehavior()) {
//                case "view": acc.views++; break;
//                case "click": acc.clicks++; break;
//                case "add_to_cart": acc.cartAdds++; break;
//                case "purchase": acc.purchases++; break;
//                case "repeat_purchase": acc.repeatPurchases++; break;
//            }
//            return acc;
//        }
//
//        @Override
//        public ProductMetrics getResult(ProductAccumulator acc) {
//            return new ProductMetrics(
//                    acc.productId,
//                    System.currentTimeMillis(),
//                    acc.views,
//                    acc.clicks,
//                    acc.cartAdds,
//                    acc.purchases,
//                    acc.repeatPurchases
//            );
//        }
//
//        @Override
//        public ProductAccumulator merge(ProductAccumulator a, ProductAccumulator b) {
//            a.views += b.views;
//            a.clicks += b.clicks;
//            a.cartAdds += b.cartAdds;
//            a.purchases += b.purchases;
//            a.repeatPurchases += b.repeatPurchases;
//            return a;
//        }
//    }
}
