package com.example.qnmd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.qnmd.mapper")
public class QnmdApplication {

    public static void main(String[] args) {
        SpringApplication.run(QnmdApplication.class, args);
    }

}
