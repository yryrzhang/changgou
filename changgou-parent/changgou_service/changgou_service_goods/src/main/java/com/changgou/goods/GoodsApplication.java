package com.changgou.goods;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Gordon Zhang
 * @Date: 4/23/2020 3:55 PM
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.goods.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);
    }
}