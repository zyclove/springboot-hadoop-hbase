package com.example.springboothadoophbase.service;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class HBaseService {


    @Autowired
    private HbaseTemplate hbaseTemplate;


    public boolean createTable(String tableName, String... column) {
        HBaseAdmin admin;
        try {
            // 从hbaseTemplate 获取configuration对象,用来初始化admin
            admin = new HBaseAdmin(hbaseTemplate.getConfiguration());
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
            for (int i = 0; i < column.length; i++) {
                tableDescriptor.addFamily(new HColumnDescriptor(column[i]));
            }
            admin.createTable(tableDescriptor);
            return admin.tableExists(tableName);
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}