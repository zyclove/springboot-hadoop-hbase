package com.example.springboothadoophbase;

import com.example.springboothadoophbase.dao.mysql.ClientUploadInstallEventMapper;
import com.example.springboothadoophbase.entity.ClientUploadInstallEvent;
import com.example.springboothadoophbase.entity.ClientUploadInstallEventExample;
import com.example.springboothadoophbase.util.DateUtil;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PhoenixTest {

    @Autowired
    ClientUploadInstallEventMapper clientUploadInstallEventMapper;

    @Test
    public void test() throws SQLException {
        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement stmt;
        ResultSet rs;
        Connection con = DriverManager.getConnection("jdbc:phoenix:hadoop1,hadoop2,hadoop3:2181");
        stmt = con.createStatement();
        String sql = "select * from CLIENT_UPLOAD_INSTALL_EVENT where ANDROID_ID = '1591a20e9277721c' limit 1";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.print("ANDROID_ID:"+rs.getString("ANDROID_ID"));
            System.out.println(",PACKAGE_NAME:"+rs.getString("PACKAGE_NAME"));
        }
        stmt.close();
        con.close();
    }

    @Test
    public void test1() throws SQLException {
        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement stmt;
        ResultSet rs;
        Connection con = DriverManager.getConnection("jdbc:phoenix:192.168.53.134:2181");
        stmt = con.createStatement();
        String sql = "select count(1) from CLIENT_UPLOAD_INSTALL_EVENT";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.print("count:"+rs.getInt("COUNT(1)"));
        }
        stmt.close();
        con.close();
    }

    @Test
    public void testInsert() throws SQLException {
        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement stmt;
        Connection con = DriverManager.getConnection("jdbc:phoenix:hadoop1:2181");
        stmt = con.createStatement();
//        PageHelper.startPage(1, 10000);
        ClientUploadInstallEventExample clientUploadInstallEventExample = new ClientUploadInstallEventExample();
        List<ClientUploadInstallEvent> clientUploadInstallEvents = clientUploadInstallEventMapper.selectByExample(clientUploadInstallEventExample);
        new PageInfo(clientUploadInstallEvents);
        for(ClientUploadInstallEvent clientUploadInstallEvent:clientUploadInstallEvents) {
            String android_id = clientUploadInstallEvent.getAndroidId();
            String package_name = clientUploadInstallEvent.getPackageName();
            String system = clientUploadInstallEvent.getSystem();
            String country = clientUploadInstallEvent.getCountry();
            String media_source = clientUploadInstallEvent.getMediaSource();
            String appsflyer_id = clientUploadInstallEvent.getAppsflyerId();
            String channel = clientUploadInstallEvent.getChannel();
            String campaign = clientUploadInstallEvent.getCampaign();
            String ad = clientUploadInstallEvent.getAd();
            String adset = clientUploadInstallEvent.getAdset();
            String upload_time1 = DateUtil.dateToStrLong(clientUploadInstallEvent.getUploadTime1());
            Date upload_time2 = clientUploadInstallEvent.getUploadTime2();

            Calendar cal = Calendar.getInstance();
            cal.setTime(upload_time2);
            cal.add(Calendar.HOUR_OF_DAY, 8);
            Date upload_time_beijing = cal.getTime();

            String upload_time2_str = DateUtil.dateToStrLong(upload_time2);
            String upload_time_beijing_str = DateUtil.dateToStr(upload_time_beijing);
            String create_time = DateUtil.dateToStrLong(clientUploadInstallEvent.getCreateTime());
            String build_id = clientUploadInstallEvent.getBuildId();
            String build_model = clientUploadInstallEvent.getBuildModel();
            String language_country = clientUploadInstallEvent.getLanguageCountry();
            String event_timestamp = String.valueOf(clientUploadInstallEvent.getEventTimestamp());
            String agency = clientUploadInstallEvent.getAgency();
            String sql = "upsert into client_upload_install_event values" +
                    "('" + android_id + "','" + package_name + "','" + system + "','" + country + "','" + media_source + "','" + appsflyer_id + "','" + channel
                    + "','" + campaign + "','" + ad + "','" + adset + "','" + upload_time1 + "','" + upload_time2_str + "','" + upload_time_beijing_str +"','" + create_time + "','" + build_id + "','" + build_model + "','" + language_country + "','" + event_timestamp + "','" + agency + "')";
            stmt.executeUpdate(sql);
            con.commit();
        }
        stmt.close();
        con.close();
    }

    @Test
    public void delete() throws SQLException {
        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement stmt;
        Connection con = DriverManager.getConnection("jdbc:phoenix:hadoop1,hadoop2,hadoop3:2181");
        stmt = con.createStatement();
        String sql="delete from us_population where CITY = 'yangzheng'";
        stmt.executeUpdate(sql);
        con.commit();
        stmt.close();
        con.close();
    }

}
