package io.github.seata.demo.common.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableConfigurationProperties(DruidDataSourceProperties.class)
@AutoConfigureBefore({DruidDataSourceAutoConfigure.class})
public class SeataDataSourceConfiguration {

    private DruidDataSource dataSource(DruidDataSourceProperties druidDataSourceProperties) {
        return new DruidDataSourceWrapper(druidDataSourceProperties);
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DruidDataSourceProperties druidDataSourceProperties) {
        return new DataSourceProxy(dataSource(druidDataSourceProperties));
    }

    @Bean("jdbcTemplate")
    @ConditionalOnBean(DataSourceProxy.class)
    public JdbcTemplate jdbcTemplate(DataSourceProxy dataSourceProxy) {
        return new JdbcTemplate(dataSourceProxy);
    }



}
