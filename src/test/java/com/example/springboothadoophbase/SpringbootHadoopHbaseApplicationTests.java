package com.example.springboothadoophbase;

import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: hbaseTemplate操作 hbase
 * @author: yangzheng
 * @date: 2019/7/5 : 16:27
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHadoopHbaseApplicationTests {

    @Autowired
    HbaseTemplate hbaseTemplate;

    @Test
    public void contextLoads() {
        String tableName = "hbase-test2";
        TableName tableName1 = TableName.valueOf(tableName);
        String[] column = {"prop"};
        Admin admin;
        try {
            Connection connection = ConnectionFactory.createConnection(hbaseTemplate.getConfiguration());
            admin = connection.getAdmin();
            // 从hbaseTemplate 获取configuration对象,用来初始化admin
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName1);
            for (int i = 0; i < column.length; i++) {
                tableDescriptor.addFamily(new HColumnDescriptor(column[i]));
            }
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

    @Test
    public void createTable() {
        String tableName = "client_upload_install_event";
        TableName tableName1 = TableName.valueOf(tableName);
        String[] column = {
                "property"
        };
        Admin admin;
        try {
            Connection connection = ConnectionFactory.createConnection(hbaseTemplate.getConfiguration());
            admin = connection.getAdmin();
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName1);
            for (int i = 0; i < column.length; i++) {
                tableDescriptor.addFamily(new HColumnDescriptor(column[i]));
            }
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
    public void execute() {
//        insert();
//        System.out.println(get("hbase-test1","123","c1","name"));
        List<Map<String, Object>> row = find("client_upload_install_event", "2019-07-12bff75e7c8e0296b2com.recorder.capture.videoeditor.gamelive", "property");
        for (Map<String, Object> stringObjectMap : row) {
            System.out.println(stringObjectMap);
            System.out.println(stringObjectMap.get("property_upload_time2"));
        }
//        insertTable();
    }

    public boolean insertTable() {
        String tableName = "client_upload_install_event";
        return hbaseTemplate.execute(tableName, (hTableInterface) -> {
            boolean flag = false;
            try {
                Put put = new Put("1".getBytes());
                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("package_name"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("version"), Bytes.toBytes("1.2"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("android_id"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("system"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("country"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("media_source"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("appsflyer_id"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("channel"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("campaign"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("ad"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("adset"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("upload_time1"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("upload_time2"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("create_time"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("build_id"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("build_model"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("language_country"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("event_timestamp"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("rdid_advertisingid"), Bytes.toBytes("com.1234.com"));

                put.addColumn(Bytes.toBytes("property"),
                        Bytes.toBytes("agency"), Bytes.toBytes("com.1234.com"));

                hTableInterface.put(put);
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return flag;
        });
    }

    public boolean insert() {
        String tableName = "hbase-test1";
        return hbaseTemplate.execute(tableName, (hTableInterface) -> {
            boolean flag = false;
            try {
                Put put = new Put("124".getBytes());
                put.addColumn(Bytes.toBytes("c1"),
                        Bytes.toBytes("name"), Bytes.toBytes("raju2"));

                put.addColumn(Bytes.toBytes("c2"),
                        Bytes.toBytes("city"), Bytes.toBytes("hyderabad2"));

                hTableInterface.put(put);
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return flag;
        });
    }

    /**
     * 通过表名  key 和 列族 和列 获取一个数据
     *
     * @param tableName
     * @param rowName
     * @param familyName
     * @param qualifier
     * @return
     */
    public String get(String tableName, String rowName, String familyName, String qualifier) {
        return hbaseTemplate.get(tableName, rowName, familyName, qualifier, new RowMapper<String>() {
            @Override
            public String mapRow(Result result, int i) {
                List<Cell> ceList = result.listCells();
                String res = "";
                if (ceList != null && ceList.size() > 0) {
                    for (Cell cell : ceList) {
                        res = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                    }
                }
                return res;
            }
        });
    }

    /**
     * 通过表名，开始行键和结束行键获取数据
     *
     * @param tableName
     * @param startRow
     * @param stopRow
     * @return
     */
    public List<Map<String, Object>> find(String tableName, String startRow, String stopRow) {
        Scan scan = new Scan();
        if (startRow == null) {
            startRow = "";
        }
        if (stopRow == null) {
            stopRow = "";
        }
        scan.setStartRow(Bytes.toBytes(startRow));
        scan.setStopRow(Bytes.toBytes(stopRow));
        /* PageFilter filter = new PageFilter(5);
         scan.setFilter(filter);*/
        return hbaseTemplate.find(tableName, scan, (result,rowNum)->{
            List<Cell> ceList = result.listCells();
            Map<String,Object> map = new HashMap<>();
            String  row = "";
            if(ceList!=null&&ceList.size()>0){
                for(Cell cell:ceList){
                    row =Bytes.toString( cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                    String value =Bytes.toString( cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                    String family =  Bytes.toString(cell.getFamilyArray(),cell.getFamilyOffset(),cell.getFamilyLength());
                    String quali = Bytes.toString( cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength());
                    map.put(family+"_"+quali, value);
                }
                map.put("row",row );
            }
            return  map;});
    }

}
