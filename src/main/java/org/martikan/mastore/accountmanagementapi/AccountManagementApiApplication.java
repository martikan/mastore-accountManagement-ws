package org.martikan.mastore.accountmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementApiApplication.class, args);
    }

}
