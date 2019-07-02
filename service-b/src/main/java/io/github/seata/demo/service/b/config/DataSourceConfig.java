package io.github.seata.demo.service.b.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;

/**
 * @author youfeng.zhu
 */
@Configuration
@AutoConfigureBefore({DruidDataSourceAutoConfigure.class})
public class DataSourceConfig {

    DruidDataSource dataSource() throws Exception {
        System.getProperties().load(Objects.requireNonNull(DataSourceConfig.class.getClassLoader().getResourceAsStream("application.properties")));
        return new DruidDataSource();
    }

    @Bean
    public DataSourceProxy dataSourceProxy() throws Exception {
        return new DataSourceProxy(dataSource());
    }

    @Bean("jdbcTemplate")
    @ConditionalOnBean(DataSourceProxy.class)
    public JdbcTemplate jdbcTemplate(DataSourceProxy dataSourceProxy) {
        return new JdbcTemplate(dataSourceProxy);
    }

}
