package com.example.mallzhc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MallZhcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallZhcApplication.class, args);
    }

}
