package com.example.springboothadoophbase;

import com.example.springboothadoophbase.dao.mysql.ClientUploadInstallEventMapper;
import com.example.springboothadoophbase.entity.ClientUploadInstallEvent;
import com.example.springboothadoophbase.entity.ClientUploadInstallEventExample;
import com.example.springboothadoophbase.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlToHbaseTest {

    @Autowired
    @Qualifier("hbaseConnection")
    Connection hbaseConnection;

    @Autowired
    ClientUploadInstallEventMapper clientUploadInstallEventMapper;

    @Test
    public void contextLoads() throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "192.168.53.134");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort", "2181"); //端口号
        Connection connection = ConnectionFactory.createConnection(config);
        String tableName = "CLIENT_UPLOAD_INSTALL_EVENT";
        Admin admin;
        try {
            admin = connection.getAdmin();
            List<ColumnFamilyDescriptor> familyDescriptors = new ArrayList<>(1);
            familyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("PROPERTY")).build());

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

    @Test
    public void test() throws IOException {

        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum","192.168.53.134");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        Connection connection = ConnectionFactory.createConnection(config);

        String tableName = "CLIENT_UPLOAD_INSTALL_EVENT";
        Table table = connection.getTable(TableName.valueOf(tableName));
//        for(int i =46;i<200;i++) {
            PageHelper.startPage(1, 10000);
            ClientUploadInstallEventExample clientUploadInstallEventExample = new ClientUploadInstallEventExample();
//        clientUploadInstallEventExample.setOrderByClause("id desc");
            List<ClientUploadInstallEvent> clientUploadInstallEvents = clientUploadInstallEventMapper.selectByExample(clientUploadInstallEventExample);
            new PageInfo<>(clientUploadInstallEvents);
            if (!CollectionUtils.isEmpty(clientUploadInstallEvents)) {
                for (ClientUploadInstallEvent clientUploadInstallEvent : clientUploadInstallEvents) {
                    insertTable(table, clientUploadInstallEvent);
                }
            }
//        }

        table.close();
        connection.close();
    }

    public void insertTable(Table table, ClientUploadInstallEvent clientUploadInstallEvent) throws IOException {

        Date uploadTime2 = clientUploadInstallEvent.getUploadTime2();
        String date = DateUtil.dateToStrLong(uploadTime2);
        String androidId = clientUploadInstallEvent.getAndroidId();
        String packageName = clientUploadInstallEvent.getPackageName();
        String rowKey = date+"_"+androidId+"_"+packageName;
        Put put = new Put(rowKey.getBytes());

        if(packageName!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("PACKAGE_NAME"), Bytes.toBytes(packageName));
        }

        if(clientUploadInstallEvent.getVersion()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("VERSION"), Bytes.toBytes(clientUploadInstallEvent.getVersion()));
        }

        if(androidId!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("ANDROID_ID"), Bytes.toBytes(androidId));
        }

        if(clientUploadInstallEvent.getSystem()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("SYSTEM"), Bytes.toBytes(clientUploadInstallEvent.getSystem()));
        }

        if(clientUploadInstallEvent.getCountry()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("COUNTRY"), Bytes.toBytes(clientUploadInstallEvent.getCountry()));
        }

        if(clientUploadInstallEvent.getMediaSource()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("MEDIA_SOURCE"), Bytes.toBytes(clientUploadInstallEvent.getMediaSource()));
        }

        if(clientUploadInstallEvent.getAppsflyerId()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("APPSFLYER_ID"), Bytes.toBytes(clientUploadInstallEvent.getAppsflyerId()));
        }

        if(clientUploadInstallEvent.getChannel()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("CHANNEL"), Bytes.toBytes(clientUploadInstallEvent.getChannel()));
        }

        if(clientUploadInstallEvent.getCampaign()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("CAMPAIGN"), Bytes.toBytes(clientUploadInstallEvent.getCampaign()));
        }

        if(clientUploadInstallEvent.getAd()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("AD"), Bytes.toBytes(clientUploadInstallEvent.getAd()));
        }

        if(clientUploadInstallEvent.getAdset()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("ADSET"), Bytes.toBytes(clientUploadInstallEvent.getAdset()));
        }

        if(clientUploadInstallEvent.getUploadTime1()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("UPLOAD_TIME1"), Bytes.toBytes(DateUtil.dateToStrLong(clientUploadInstallEvent.getUploadTime1())));
        }

        if(clientUploadInstallEvent.getUploadTime2()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("UPLOAD_TIME2"), Bytes.toBytes(DateUtil.dateToStrLong(clientUploadInstallEvent.getUploadTime2())));
            Calendar cal = Calendar.getInstance();
            cal.setTime(clientUploadInstallEvent.getUploadTime2());
            cal.add(Calendar.HOUR_OF_DAY, 8);

            Date upload_time_beijing = cal.getTime();
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("UPLOAD_TIME2_BEIJING"), Bytes.toBytes(DateUtil.dateToStr(upload_time_beijing)));
        }

        if(clientUploadInstallEvent.getCreateTime()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("CREATE_TIME"), Bytes.toBytes(DateUtil.dateToStrLong(clientUploadInstallEvent.getCreateTime())));
        }

        if(clientUploadInstallEvent.getBuildId()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("BUILD_ID"), Bytes.toBytes(clientUploadInstallEvent.getBuildId()));
        }

        if(clientUploadInstallEvent.getBuildModel()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("BUILD_MODEL"), Bytes.toBytes(clientUploadInstallEvent.getBuildModel()));
        }

        if(clientUploadInstallEvent.getLanguageCountry()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("LANGUAGE_COUNTRY"), Bytes.toBytes(clientUploadInstallEvent.getLanguageCountry()));
        }

        if(clientUploadInstallEvent.getLanguageCountry()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("EVENT_TIMESTAMP"), Bytes.toBytes(clientUploadInstallEvent.getEventTimestamp().toString()));
        }

        if(clientUploadInstallEvent.getRdidAdvertisingid()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("RDID_ADVERTISINGID"), Bytes.toBytes(clientUploadInstallEvent.getRdidAdvertisingid()));
        }

        if(clientUploadInstallEvent.getAgency()!=null) {
            put.addColumn(Bytes.toBytes("PROPERTY"),
                    Bytes.toBytes("AGENCY"), Bytes.toBytes(clientUploadInstallEvent.getAgency()));
        }

        table.put(put);
    }


    /**
     * 行键过滤
     * @return
     */
    @Test
    public void getLike1() throws IOException {
        String key = "912dae477b89e8a3";
        String tableName = "CLIENT_UPLOAD_INSTALL_EVENT";
        Filter filter2 = new RowFilter(CompareOperator.EQUAL, new RegexStringComparator(key));
        Scan scan = new Scan();
        scan.setFilter(filter2);
        Table table = hbaseConnection.getTable(TableName.valueOf(tableName));
        ResultScanner scanner = table.getScanner(scan);
        try {
            for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
                NavigableMap<byte[], byte[]> property = rr.getFamilyMap(Bytes.toBytes("PROPERTY"));
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
        hbaseConnection.close();
    }

    /**
     * 列过滤
     * @param key
     * @return
     */
    public void getLineLike(String key) throws IOException {
        String tableName = "client_upload_install_event";
//        Filter filter2 = new QualifierFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(key));
//        Filter filter2 = new QualifierFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(key.getBytes()));
        Filter filter2 = new SingleColumnValueFilter(Bytes.toBytes("PROPERTY"),Bytes.toBytes("media_source"),
                CompareOperator.EQUAL,new SubstringComparator(key));
        Filter filter3 = new SingleColumnValueFilter(Bytes.toBytes("PROPERTY"),Bytes.toBytes("package_name"),
                CompareOperator.EQUAL,new SubstringComparator("com.dailyhoroscope.facesecret"));
        Filter filter4 = new SingleColumnValueFilter(Bytes.toBytes("PROPERTY"),Bytes.toBytes("language_country"),
                CompareOperator.EQUAL,new SubstringComparator("en_US"));

        FilterList filterList=new FilterList(FilterList.Operator.MUST_PASS_ALL);
        filterList.addFilter(filter2);
        filterList.addFilter(filter3);
        filterList.addFilter(filter4);
        Scan scan=new Scan();
        scan.setFilter(filterList);
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "192.168.53.10");  //hbase 服务地址
        config.set("hbase.zookeeper.property.clientPort", "2181"); //端口号
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf(tableName));
        ResultScanner scanner = table.getScanner(scan);
        try {
            for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
                System.out.println("Found row: " + rr);
            }
        } finally {
            scanner.close();
        }
        if (table != null) {
            table.close();
        }
        connection.close();
    }

    @Test
    public void getAndroidInstallcount() throws Exception {
        String date = "2019-07-21";

    }
}
