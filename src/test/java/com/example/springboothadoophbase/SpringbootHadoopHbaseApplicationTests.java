package com.example.springboothadoophbase;

import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHadoopHbaseApplicationTests {

    @Autowired
    HbaseTemplate hbaseTemplate;

    @Test
    public void contextLoads() {
        String tableName = "hbase-test1";
        String[] column = {"c1","c2"};
        HBaseAdmin admin;
        try {
            // 从hbaseTemplate 获取configuration对象,用来初始化admin
            admin = new HBaseAdmin(hbaseTemplate.getConfiguration());
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
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
     *数据插入
     *@author : zhangai
     *@date : 11:42 2018/6/22
     *@description：
     */
    @Test
    public void execute() {
//        insert();
//        System.out.println(get("hbase-test1","123","c1","name"));
        List<Map<String, Object>> row = find("hbase-test1", "123", "124");
        for (Map<String, Object> stringObjectMap : row) {
            System.out.println(stringObjectMap);
        }
    }

    public boolean insert(){
        String tableName = "hbase-test1";
        return  hbaseTemplate.execute(tableName,(hTableInterface)->{
            boolean flag = false;
            try{
                Put put = new Put("124".getBytes());
                put.add(Bytes.toBytes("c1"),
                        Bytes.toBytes("name"),Bytes.toBytes("raju2"));

                put.add(Bytes.toBytes("c2"),
                        Bytes.toBytes("city"),Bytes.toBytes("hyderabad2"));

                hTableInterface.put(put);
                flag = true;
            }catch(Exception e){
                e.printStackTrace();
            }
            return flag;
        });
    }

    /**
     * 通过表名  key 和 列族 和列 获取一个数据
     * @param tableName
     * @param rowName
     * @param familyName
     * @param qualifier
     * @return
     */
    public String get(String tableName ,String rowName, String familyName, String qualifier) {
        return hbaseTemplate.get(tableName, rowName,familyName,qualifier ,new RowMapper<String>(){
            @Override
            public String mapRow(Result result, int i)  {
                List<Cell> ceList = result.listCells();
                String res = "";
                if(ceList!=null&&ceList.size()>0){
                    for(Cell cell:ceList){
                        res = Bytes.toString( cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                    }
                }
                return res;
            }
        });
    }

    /**
     * 通过表名，开始行键和结束行键获取数据
     * @param tableName
     * @param startRow
     * @param stopRow
     * @return
     */
    public List<Map<String,Object>> find(String tableName , String startRow,String stopRow) {
        Scan scan = new Scan();
        if(startRow==null){
            startRow="";
        }
        if(stopRow==null){
            stopRow="";
        }
        scan.setStartRow(Bytes.toBytes(startRow));
        scan.setStopRow(Bytes.toBytes(stopRow));
        /* PageFilter filter = new PageFilter(5);
         scan.setFilter(filter);*/
        return  hbaseTemplate.find(tableName, scan,new RowMapper<Map<String,Object>>(){
            @Override
            public Map<String,Object> mapRow(Result result, int rowNum) throws Exception {
                List<Cell> ceList =   result.listCells();
                Map<String,Object> map = new HashMap<String,Object>();
                Map<String,Map<String,Object>> returnMap = new HashMap<String,Map<String,Object>>();
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
                return  map;
            }
        });
    }

}
