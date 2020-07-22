package com.dj.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 杨承雨
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.dj.hotel.mapper")
@ServletComponentScan("com.dj.ssm.config")
public class HotelWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelWorkApplication.class, args);
    }

}
