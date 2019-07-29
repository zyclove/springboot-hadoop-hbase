package com.example.springboothadoophbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

/**
 * @description: hbaseTemplate操作 hbase
 * @author: yangzheng
 * @date: 2019/7/5 : 16:27
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHadoopHbaseApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "192.168.53.10");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort", "2181"); //端口号
        Connection connection = ConnectionFactory.createConnection(config);
        String tableName = "hbase-test3";
        Admin admin;
        try {
            admin = connection.getAdmin();
            List<ColumnFamilyDescriptor> familyDescriptors = new ArrayList<>(1);
            familyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("prop")).build());

            // 从hbaseTemplate 获取configuration对象,用来初始化admin
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName))
                    .setColumnFamilies(familyDescriptors)
                    .build();
            admin.createTable(tableDescriptor);
            System.out.println(tableName);
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 数据插入
     *
     * @author : zhangai
     * @date : 11:42 2018/6/22
     * @description：
     */
    @Test
    public void execute() throws IOException {
        String rowKey = "4";
        System.out.println(rowKey);
        Put put = new Put(rowKey.getBytes());
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum","192.168.53.10");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        Connection connection = ConnectionFactory.createConnection(config);

        String tableName = "hbase-test3";
        Table table = connection.getTable(TableName.valueOf(tableName));


        put.addColumn(Bytes.toBytes("prop"),
                Bytes.toBytes("name"), Bytes.toBytes("yangchang"));
        put.addColumn(Bytes.toBytes("prop"),
                Bytes.toBytes("age"), Bytes.toBytes("18"));

        table.put(put);


    }


    /**
     * 通过表名  key 和 列族 和列 获取一个数据
     *
     * @return
     */
    @Test
    public void get() throws IOException {
        Scan scan = new Scan();
        String tableName = "hbase-test3";
        queryData(tableName, scan);
    }

    /**
     * 通过表名，开始行键和结束行键获取数据
     *
     * @return
     */
    @Test
    public void find() throws IOException {
        Scan scan = new Scan();
        scan.withStartRow(Bytes.toBytes("2"));
        scan.withStopRow(Bytes.toBytes("4"));
        this.queryData("hbase-test3",scan);
    }

    /**
     * 通过表名以及过滤条件查询数据
     * @author zifangsky
     * @date 2018/7/4 16:13
     * @since 1.0.0
     * @param tableName 表名
     * @param scan 过滤条件
     * @return java.util.Map<java.lang.String,java.util.Map<java.lang.String,java.lang.String>>
     */
    private void queryData(String tableName,Scan scan) throws IOException {

        // 获取表
        Table table;
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "192.168.53.10");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort", "2181"); //端口号
        Connection connection = ConnectionFactory.createConnection(config);
        table = connection.getTable(TableName.valueOf(tableName));
        ResultScanner scanner = table.getScanner(scan);
        try {
            for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
                System.out.println("行键: " + new String(rr.getRow(),"utf-8"));
                NavigableMap<byte[], byte[]> property = rr.getFamilyMap(Bytes.toBytes("prop"));
                for(NavigableMap.Entry<byte[], byte[]> entry : property.entrySet()){
                    String mapKey = new String(entry.getKey(),"utf-8");
                    String mapValue = new String(entry.getValue(),"utf-8");
                    System.out.println(mapKey+":"+mapValue);
                }
            }
        } finally {
            scanner.close();
        }
        if (table != null) {
            table.close();
        }
        connection.close();


    }

}
