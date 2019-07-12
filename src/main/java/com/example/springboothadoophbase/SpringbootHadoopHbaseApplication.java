package com.example.springboothadoophbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.springboothadoophbase.dao"})
public class SpringbootHadoopHbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHadoopHbaseApplication.class, args);
    }

}
