package com.dream;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@SpringBootApplication
@MapperScan(basePackages = "com.dream.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
