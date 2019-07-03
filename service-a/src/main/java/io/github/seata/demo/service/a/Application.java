package io.github.seata.demo.service.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableFeignClients
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "io.github")
@EnableOAuth2Client
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
