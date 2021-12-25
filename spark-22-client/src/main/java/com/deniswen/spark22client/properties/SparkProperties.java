package com.deniswen.spark22client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author deniswen
 * @date 2021/12/25 14:32
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "spark22")
public class SparkProperties {

    private String appName;

    private String metastoreUris;

    private String hiveVersion;

    private String hiveJarsPath;

    private String master;

    private String reqUrl;

    private String uiPort;

}
