package com.example.springboothadoophbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Adam
 * @Description: //TODO
 * @Title: HbaseKerberosTest
 * @ProjectName springboot-hadoop-hbase
 * @date 2019/8/19 23:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseKerberosTest {

    @Test
    public void test() throws Exception{
        System.setProperty("java.security.krb5.conf", "D:\\javaProject\\springboot-hadoop-hbase\\src\\main\\resources\\kerberos\\krb5.conf");
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
}
