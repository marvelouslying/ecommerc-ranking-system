package com_ecommerce_ranking.models

import java.sql.Timestamp

case class HistoricalMetrics(
                              productId: String,
                              date: Timestamp,
                              views: Long,
                              clicks: Long,
                              cartAdds: Long,
                              purchases: Long,
                              repeatPurchases: Long,
                              repurchaseRate: Double
                            )
