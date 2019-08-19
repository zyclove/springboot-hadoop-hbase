package com.example.springboothadoophbase.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

//@Configuration
public class HbaseConfig {
    @Value("${hbase.zookeeper.quorum}")
    String quorum;
    @Value("${hbase.zookeeper.property.clientPort}")
    String clientPort;

    @Bean(name = "hbaseConnection")
    public Connection connection() throws IOException {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum",quorum);  //hbase 服务地址
        configuration.set("hbase.zookeeper.property.clientPort",clientPort); //端口号
        Connection connection = ConnectionFactory.createConnection(configuration);
        return connection;
    }

}
