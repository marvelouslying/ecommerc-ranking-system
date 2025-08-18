# 基于官方Flink镜像
FROM flink:1.14-scala_2.12

# 设置工作目录
WORKDIR /opt/flink

# 复制构建好的JAR文件
COPY target/ecommerce-realtime-processor-1.0.jar /opt/flink/usrlib/

# 设置启动命令
CMD ["standalone-job", "--job-classname", "com.ecommerce.ranking.RealtimeProcessor"]