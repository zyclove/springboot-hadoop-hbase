package com.example.springboothadoophbase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.springboothadoophbase.dao.ClientUploadInstallEventMapper;
import com.example.springboothadoophbase.entity.ClientUploadInstallEvent;
import com.example.springboothadoophbase.entity.ClientUploadInstallEventExample;
import com.example.springboothadoophbase.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlToHbaseTest {
    @Autowired
    ClientUploadInstallEventMapper clientUploadInstallEventMapper;

    @Autowired
    HbaseTemplate hbaseTemplate;

    @Test
    public void test(){
        PageHelper.startPage(1, 10);
        ClientUploadInstallEventExample clientUploadInstallEventExample = new ClientUploadInstallEventExample();
        clientUploadInstallEventExample.setOrderByClause("id desc");
        List<ClientUploadInstallEvent> clientUploadInstallEvents = clientUploadInstallEventMapper.selectByExample(clientUploadInstallEventExample);
        new PageInfo<>(clientUploadInstallEvents);
        if(!CollectionUtils.isEmpty(clientUploadInstallEvents)){
            for (ClientUploadInstallEvent clientUploadInstallEvent : clientUploadInstallEvents) {
                insertTable(clientUploadInstallEvent);
            }
        }
    }

    public boolean insertTable(ClientUploadInstallEvent clientUploadInstallEvent){

        Date uploadTime2 = clientUploadInstallEvent.getUploadTime2();
        String date = DateUtil.dateToStrLong(uploadTime2);
        String androidId = clientUploadInstallEvent.getAndroidId();
        String packageName = clientUploadInstallEvent.getPackageName();
        String rowKey = date+"_"+androidId+"_"+packageName;
        System.out.println(rowKey);

        String tableName = "client_upload_install_event";
        return  hbaseTemplate.execute(tableName,(hTableInterface)->{
            boolean flag = false;
            try{
                Put put = new Put(rowKey.getBytes());

                if(packageName!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("package_name"), Bytes.toBytes(packageName));
                }

                if(clientUploadInstallEvent.getVersion()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("version"), Bytes.toBytes(clientUploadInstallEvent.getVersion()));
                }

                if(androidId!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("android_id"), Bytes.toBytes(androidId));
                }

                if(clientUploadInstallEvent.getSystem()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("system"), Bytes.toBytes(clientUploadInstallEvent.getSystem()));
                }

                if(clientUploadInstallEvent.getCountry()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("country"), Bytes.toBytes(clientUploadInstallEvent.getCountry()));
                }

                if(clientUploadInstallEvent.getMediaSource()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("media_source"), Bytes.toBytes(clientUploadInstallEvent.getMediaSource()));
                }

                if(clientUploadInstallEvent.getAppsflyerId()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("appsflyer_id"), Bytes.toBytes(clientUploadInstallEvent.getAppsflyerId()));
                }

                if(clientUploadInstallEvent.getChannel()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("channel"), Bytes.toBytes(clientUploadInstallEvent.getChannel()));
                }

                if(clientUploadInstallEvent.getCampaign()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("campaign"), Bytes.toBytes(clientUploadInstallEvent.getCampaign()));
                }

                if(clientUploadInstallEvent.getAd()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("ad"), Bytes.toBytes(clientUploadInstallEvent.getAd()));
                }

                if(clientUploadInstallEvent.getAdset()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("adset"), Bytes.toBytes(clientUploadInstallEvent.getAdset()));
                }

                if(clientUploadInstallEvent.getUploadTime1()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("upload_time1"), Bytes.toBytes(DateUtil.dateToStrLong(clientUploadInstallEvent.getUploadTime1())));
                }

                if(clientUploadInstallEvent.getUploadTime2()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("upload_time2"), Bytes.toBytes(DateUtil.dateToStrLong(clientUploadInstallEvent.getUploadTime2())));
                }

                if(clientUploadInstallEvent.getCreateTime()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("create_time"), Bytes.toBytes(DateUtil.dateToStrLong(clientUploadInstallEvent.getCreateTime())));
                }

                if(clientUploadInstallEvent.getBuildId()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("build_id"), Bytes.toBytes(clientUploadInstallEvent.getBuildId()));
                }

                if(clientUploadInstallEvent.getBuildModel()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("build_model"), Bytes.toBytes(clientUploadInstallEvent.getBuildModel()));
                }

                if(clientUploadInstallEvent.getLanguageCountry()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("language_country"), Bytes.toBytes(clientUploadInstallEvent.getLanguageCountry()));
                }

                if(clientUploadInstallEvent.getLanguageCountry()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("event_timestamp"), Bytes.toBytes(clientUploadInstallEvent.getEventTimestamp().toString()));
                }

                if(clientUploadInstallEvent.getRdidAdvertisingid()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("rdid_advertisingid"), Bytes.toBytes(clientUploadInstallEvent.getRdidAdvertisingid()));
                }

                if(clientUploadInstallEvent.getAgency()!=null) {
                    put.addColumn(Bytes.toBytes("property"),
                            Bytes.toBytes("agency"), Bytes.toBytes(clientUploadInstallEvent.getAgency()));
                }
                hTableInterface.put(put);
                flag = true;
            }catch(Exception e){
                e.printStackTrace();
            }
            return flag;
        });


    }

    @Test
    public void get(){
        String key = "a34db91574eb4449_com.dailyhoroscope.facesecret";
        List<Map<String, Object>> like = getLike1(key);
        System.out.println(JSON.toJSONString(like));
        System.out.println(like);
    }

    public List<Map<String, Object>> getLike1(String key){
        String tableName = "client_upload_install_event";
        Filter filter2 = new RowFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(key));
        Scan scan=new Scan();
        scan.setFilter(filter2);
        return hbaseTemplate.find(tableName, scan,(result,rowNum)->{
            List<Cell> ceList = result.listCells();
            Map<String,Object> map = new HashMap<>();
            String  row = "";
            if(ceList!=null&&ceList.size()>0){
                for(Cell cell:ceList){
                    row =Bytes.toString( cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                    String value =Bytes.toString( cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
//                    String family =  Bytes.toString(cell.getFamilyArray(),cell.getFamilyOffset(),cell.getFamilyLength());
                    String quali = Bytes.toString( cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength());
                    map.put(quali, value);
                }
                map.put("row",row );
            }
            return  map;});

    }

}
