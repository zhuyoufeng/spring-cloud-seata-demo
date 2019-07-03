package io.github.seata.demo.common.config;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidDataSourceWrapper extends DruidDataSource {

    public DruidDataSourceWrapper(DruidDataSourceProperties druidDataSourceProperties) {
        super(false);
        initProperties(druidDataSourceProperties);

        configFromPropety(System.getProperties());
    }

    private void initProperties(DruidDataSourceProperties druidDataSourceProperties) {
        if (super.getName() == null) {
            super.setName(druidDataSourceProperties.getName());
        }
        if (super.getUsername() == null) {
            super.setUsername(druidDataSourceProperties.getUsername());
        }
        if (super.getPassword() == null) {
            super.setPassword(druidDataSourceProperties.getPassword());
        }
        if (super.getUrl() == null) {
            super.setUrl(druidDataSourceProperties.getUrl());
        }
        if (super.getDriverClassName() == null) {
            super.setDriverClassName(druidDataSourceProperties.getDriverClassName());
        }
        if (druidDataSourceProperties.getInitialSize() != null) {
            super.setInitialSize(druidDataSourceProperties.getInitialSize());
        }
        if (druidDataSourceProperties.getMaxActive() != null) {
            super.setMaxActive(druidDataSourceProperties.getMaxActive());
        }
        if (druidDataSourceProperties.getMinIdle() != null) {
            super.setMinIdle(druidDataSourceProperties.getMinIdle());
        }
        if (druidDataSourceProperties.getMaxWait() != null) {
            super.setMaxWait(druidDataSourceProperties.getMaxWait());
        }
        if (druidDataSourceProperties.getNotFullTimeoutRetryCount() != null) {
            super.setNotFullTimeoutRetryCount(druidDataSourceProperties.getNotFullTimeoutRetryCount());
        }
        if (super.getValidationQuery() == null && druidDataSourceProperties.getValidationQuery() != null) {
            super.setValidationQuery(druidDataSourceProperties.getValidationQuery());
        }
        if (druidDataSourceProperties.getValidationQueryTimeout() != null) {
            super.setValidationQueryTimeout(druidDataSourceProperties.getValidationQueryTimeout());
        }
        if (druidDataSourceProperties.getTestOnBorrow() != null) {
            super.setTestOnBorrow(druidDataSourceProperties.getTestOnBorrow());
        }
        if (druidDataSourceProperties.getTestOnReturn() != null) {
            super.setTestOnReturn(druidDataSourceProperties.getTestOnReturn());
        }
        if (druidDataSourceProperties.getTestWhileIdle() != null) {
            super.setTestWhileIdle(druidDataSourceProperties.getTestWhileIdle());
        }
        if (druidDataSourceProperties.getPoolPreparedStatements() != null) {
            super.setPoolPreparedStatements(druidDataSourceProperties.getPoolPreparedStatements());
        }
        if (druidDataSourceProperties.getSharePreparedStatements() != null) {
            super.setSharePreparedStatements(druidDataSourceProperties.getSharePreparedStatements());
        }
        if (druidDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize() != null) {
            super.setMaxPoolPreparedStatementPerConnectionSize(druidDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
        }
        if (druidDataSourceProperties.getConnectionProperties() != null) {
            super.setConnectionProperties(druidDataSourceProperties.getConnectionProperties());
        }
    }
}
