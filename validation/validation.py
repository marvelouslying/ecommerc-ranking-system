import requests
import pandas as pd
import numpy as np
from sklearn.metrics import ndcg_score

def validate_ranking_improvement():
    # 获取人工运营排名
    manual_ranking = get_manual_ranking()

    # 获取算法排名
    algorithm_ranking = get_algorithm_ranking()

    # 获取实际销售数据
    actual_sales = get_actual_sales()

    # 计算NDCG
    true_relevance = actual_sales.set_index('product_id')['sales'].to_dict()

    manual_scores = [true_relevance.get(pid, 0) for pid in manual_ranking]
    algo_scores = [true_relevance.get(pid, 0) for pid in algorithm_ranking]

    manual_ndcg = ndcg_score([manual_scores], [manual_scores])
    algo_ndcg = ndcg_score([manual_scores], [algo_scores])

    improvement = (algo_ndcg - manual_ndcg) / manual_ndcg
    print(f"NDCG Improvement: {improvement:.2%}")

    # 生成验证报告
    report = {
        "manual_ndcg": manual_ndcg,
        "algorithm_ndcg": algo_ndcg,
        "improvement_rate": improvement,
        "top_10_manual": manual_ranking[:10],
        "top_10_algorithm": algorithm_ranking[:10]
    }

    return report

def get_algorithm_ranking():
    response = requests.get("http://ranking-service:8080/api/top-products?top=100")
    return [item['productId'] for item in response.json()]

# 其他辅助方法...