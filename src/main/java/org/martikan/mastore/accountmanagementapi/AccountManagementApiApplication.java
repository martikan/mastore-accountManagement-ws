package org.martikan.mastore.accountmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableReactiveMongoRepositories
@EnableDiscoveryClient
@SpringBootApplication
public class AccountManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementApiApplication.class, args);
    }

}
