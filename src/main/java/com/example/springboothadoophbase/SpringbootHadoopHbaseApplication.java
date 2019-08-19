package com.example.springboothadoophbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.springboothadoophbase.dao"})
public class SpringbootHadoopHbaseApplication {

    public static void main(String[] args) {
        System.setProperty("java.security.krb5.conf", "D:\\javaProject\\springboot-hadoop-hbase\\src\\main\\resources\\kerberos\\krb5.conf");
        SpringApplication.run(SpringbootHadoopHbaseApplication.class, args);
        System.err.println("SpringbootHadoopHbaseApplication =======> 启动成功");
    }

}
