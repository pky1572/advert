package com.example.xuerun.advert;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages ="com.example.xuerun.advert.dao")
@EnableTransactionManagement
public class AdvertApplication {

    public static void main(String[] args) {
        // 解决 java.awt.HeadlessException
        System.setProperty("java.awt.headless","false");
        SpringApplication.run(AdvertApplication.class, args);
    }

}
