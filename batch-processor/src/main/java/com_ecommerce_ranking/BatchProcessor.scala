package com_ecommerce_ranking

object BatchProcessor {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Ecommerce Historical Metrics")
      .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .config("spark.sql.hive.convertMetastoreParquet", "false")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    // 读取Hive中的用户行为数据
    val behaviorDF = spark.sql(
      """
        |SELECT
        |  product_id,
        |  behavior,
        |  COUNT(*) AS count
        |FROM user_behavior
        |WHERE event_date = CURRENT_DATE() - INTERVAL 1 DAY
        |GROUP BY product_id, behavior
      """.stripMargin)

    // 转换行为数据为宽表
    val pivotedDF = behaviorDF
      .groupBy("product_id")
      .pivot("behavior", Seq("view", "click", "purchase", "repeat_purchase"))
      .agg(sum("count"))
      .na.fill(0)

    // 计算复购率
    val resultDF = pivotedDF
      .withColumn("repurchase_rate",
        when($"purchase" > 0, $"repeat_purchase" / $"purchase").otherwise(0))
      .select(
        $"product_id",
        $"view".alias("views"),
        $"click".alias("clicks"),
        $"purchase".alias("purchases"),
        $"repurchase_rate")

    // 保存到Hive
    resultDF.write
      .mode("overwrite")
      .partitionBy("event_date")
      .saveAsTable("product_historical_metrics")

    spark.stop()
  }
}