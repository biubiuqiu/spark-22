package com.deniswen.spark22client.autoconfigure;

import com.deniswen.spark22client.properties.SparkProperties;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author deniswen
 * @date 2021/12/25 14:29
 * @description spark初始化session
 */
@Configuration
public class SparkSessionAutoConfig {

    @Resource
    private SparkProperties sparkProperties;

    /**
     * 初始化sparkSession
     * hive.metastore.uris 表示hive的metastore数据库的连接地址
     * spark.master 表示spark的模式 local 或 local[*] * 为线程的个数
     *
     * 注意！！！！！！！！！！！！！！！
     * 因为spark3.x编译时用的hive版本为2.3.7所以hive版本低于2.3.7的版本都需要指定以下的两项
     * 否则当使用select语句的时候会报错 Unable to fetch table  Invalid method name: 'get_table_req'
     * spark.sql.hive.metastore.version hive的版本
     * spark.sql.hive.metastore.jars hive jar包的位置
     *
     * @return sparkSession
     */
    @Bean("sparkSession")
    public SparkSession initSparkSession() {

        return SparkSession
                .builder()
                .appName(sparkProperties.getAppName())
                .config("spark.ui.port", sparkProperties.getUiPort())
                .config("hive.metastore.uris", sparkProperties.getMetastoreUris())
                .config("spark.master", sparkProperties.getMaster())
                .config("spark.sql.hive.metastore.version", sparkProperties.getHiveVersion())
                .config("spark.sql.hive.metastore.jars", sparkProperties.getHiveJarsPath())
                .enableHiveSupport()
                .getOrCreate();
    }
}
