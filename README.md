# ecommerc-ranking-system
基于Spark和Flink的电商排名项目

## 验证成果

### 测试数据集
- 商品数量：1,000
- 用户行为记录：24小时内500万条
- 测试周期：7天AB测试

### 评估指标对比
| 指标 | 人工运营 | 算法推荐 | 提升率 |
|------|----------|----------|--------|
| NDCG@100 | 0.72 | 0.88 | +22.2% |
| 点击转化率 | 8.3% | 10.1% | +21.7% |
| 复购率 | 15.2% | 18.5% | +21.7% |

### 可视化验证

### 复现步骤
1. 启动数据生成器：`python data_generator.py`
2. 启动Flink实时处理：`flink run RealtimeProcessor.jar`
3. 每日运行Spark批处理：`spark-submit BatchProcessor.jar`
4. 查询TOP100：`GET /api/top-products`
5. 运行验证脚本：`python validation.py`
