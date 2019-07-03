package io.github.seata.demo.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceProperties {

    private String name;
    private String username;
    private String password;
    private String url;
    private String driverClassName;
    private Integer initialSize;
    private Integer maxActive;
    private Integer minIdle;
    private Long maxWait;
    private Integer notFullTimeoutRetryCount;
    private String validationQuery;
    private Integer validationQueryTimeout;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean testWhileIdle;
    private Boolean poolPreparedStatements;
    private Boolean sharePreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private String connectionProperties;

}
