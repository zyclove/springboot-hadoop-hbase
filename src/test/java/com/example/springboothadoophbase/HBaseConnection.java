package com.example.springboothadoophbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @description: java 操作hbase
 * @author:  yangzheng
 * @date: 2019/7/5 : 16:27
 * @version:  1.0
 */
public class HBaseConnection {

    /**
     * 列出所有表
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {

        System.setProperty("java.security.krb5.conf", "D:\\javaProject\\springboot-hadoop-hbase\\src\\main\\resources\\kerberos\\krb5.conf");
//
//        //第一步，设置HBsae配置信息
        Configuration configuration = HBaseConfiguration.create();
        //注意。这里这行目前没有注释掉的，这行和问题3有关系  是要根据自己zookeeper.znode.parent的配置信息进行修改。
        configuration.set("hbase.zookeeper.quorum","hbaseserver");  //hbase 服务地址
        configuration.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        configuration.set("hadoop.security.authentication", "kerberos");
        configuration.set("hbase.security.authentication", "kerberos");
        configuration.set("hbase.master.kerberos.principal", "root/hbaseserver@GS.COM");
        //这里使用的是接口Admin   该接口有一个实现类HBaseAdmin   也可以直接使用这个实现类
        UserGroupInformation.setConfiguration(configuration);
        UserGroupInformation.loginUserFromKeytab("root/hbaseserver@GS.COM", "D:\\javaProject\\springboot-hadoop-hbase\\src\\main\\resources\\kerberos\\root.keytab");



        Admin admin = ConnectionFactory.createConnection(configuration).getAdmin();
        if(admin !=null){
            try {
                //获取到数据库所有表信息
                TableName[] tableNames = admin.listTableNames();
                for (TableName tableName : tableNames) {
                    System.out.println(tableName);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 插入一行
     * @throws IOException
     */
    public static void insert() throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum","192.168.53.10");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        // Instantiating HTable class
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("hbase-test1"));

        // Instantiating Put class
        // accepts a row name.
        Put p = new Put(Bytes.toBytes("row2"));

        // adding values using add() method
        // accepts column family name, qualifier/row name ,value
        p.addColumn(Bytes.toBytes("c1"),
                Bytes.toBytes("name"),Bytes.toBytes("raju"));

        p.addColumn(Bytes.toBytes("c2"),
                Bytes.toBytes("city"),Bytes.toBytes("hyderabad"));

        // Saving the put Instance to the HTable.
        table.put(p);
        System.out.println("data inserted");

        // closing HTable
        table.close();
    }

    public static void get() throws IOException {
        // Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum","192.168.53.10");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        // Instantiating HTable class
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("hbase-test1"));

        // Instantiating Get class
        Get g = new Get(Bytes.toBytes("row1"));

        // Reading the data
        Result result = table.get(g);

        // Reading values from Result class object
        byte [] value = result.getValue(Bytes.toBytes("c1"),Bytes.toBytes("name"));

        byte [] value1 = result.getValue(Bytes.toBytes("c2"),Bytes.toBytes("city"));

        // Printing the values
        String name = Bytes.toString(value);
        String city = Bytes.toString(value1);

        System.out.println("name: " + name + " city: " + city);
    }

}
