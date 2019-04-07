package com.kither;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("classpath:com.kither.mapper")
public class SpringMailApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringMailApp.class);
    }
}
