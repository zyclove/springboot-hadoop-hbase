package com.example.springboothadoophbase;

import com.example.springboothadoophbase.dao.hive.TestHive;
import com.example.springboothadoophbase.dao.mysql.AndroidInstallCountMapper;
import com.example.springboothadoophbase.dao.phoenix.TestPhoenix;
import com.example.springboothadoophbase.entity.AndroidInstallCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MainTest {
//    @Autowired
//    @Qualifier("phoenixJdbcTemplate")
//    JdbcTemplate phoenixJdbcTemplate;

    @Autowired
    AndroidInstallCountMapper androidInstallCountMapper;

    @Autowired
    TestPhoenix testPhoenix;

//    @Autowired
//    @Qualifier("hiveJdbcTemplate")
//    JdbcTemplate hiveJdbcTemplate;
//
    @Autowired
    TestHive testHive;
//
//    @Test
//    public void DataSourceHiveTest() {
//        Integer count =hiveJdbcTemplate.queryForObject("SELECT count(1) FROM student", Integer.class);
//        System.out.println(count);
//    }
    @Test
    public void DataSourceHiveMybatis() {
        Integer count =testHive.testHive();
        System.out.println(count);
    }

//    @Test
//    public void DataSourceTest() {
//        Integer count = phoenixJdbcTemplate.queryForObject("select count(1) from CLIENT_UPLOAD_INSTALL_EVENT", Integer.class);
//        System.out.println(count);
//    }
//
//    @Test
//    public void DataSourceTest1() {
//        Integer count = phoenixJdbcTemplate.queryForObject("select count(1) from CLIENT_UPLOAD_INSTALL_EVENT where ANDROID_ID = '3de932981ea61cbb'", Integer.class);
//        System.out.println(count);
//    }
//
//    @Test
//    public void DataSourceTest2() {
//        List<String> apps = phoenixJdbcTemplate.queryForList("select PACKAGE_NAME from CLIENT_UPLOAD_INSTALL_EVENT where UPLOAD_TIME2_BEIJING = '2019-02-11' group by PACKAGE_NAME", String.class);
////        for (String app : apps) {
////            System.out.println(app);
////        }
//        List<String> versions = phoenixJdbcTemplate.queryForList("select VERSION from CLIENT_UPLOAD_INSTALL_EVENT where UPLOAD_TIME2_BEIJING = '2019-02-11' group by VERSION", String.class);
////        for (String version : versions) {
////            System.out.println(version);
////        }
//
//        List<String> campaigns = phoenixJdbcTemplate.queryForList("select CAMPAIGN from CLIENT_UPLOAD_INSTALL_EVENT where UPLOAD_TIME2_BEIJING = '2019-02-11' group by CAMPAIGN", String.class);
////        for (String campaign : campaigns) {
////            System.out.println(campaign);
////        }
////        List<String> agencys = phoenixJdbcTemplate.queryForList("select AGENCY from CLIENT_UPLOAD_INSTALL_EVENT where UPLOAD_TIME2_BEIJING = '2019-02-11' group by AGENCY", String.class);
////        for (String agency : agencys) {
////            System.out.println(agency);
////        }
//        List<String> countrys = phoenixJdbcTemplate.queryForList("select COUNTRY from CLIENT_UPLOAD_INSTALL_EVENT where UPLOAD_TIME2_BEIJING = '2019-02-11' group by COUNTRY", String.class);
////        for (String country : countrys) {
////            System.out.println(country);
////        }
//        List<String> media_sources = phoenixJdbcTemplate.queryForList("select MEDIA_SOURCE from CLIENT_UPLOAD_INSTALL_EVENT where UPLOAD_TIME2_BEIJING = '2019-02-11' group by MEDIA_SOURCE", String.class);
////        for (String media_source : media_sources) {
////            System.out.println(media_source);
////        }
//
//        for (String app : apps) {
//            for (String version : versions) {
//                for (String campaign : campaigns) {
//                    for (String country : countrys) {
//                        for (String media_source : media_sources) {
//                            System.out.println(app);
//                            System.out.println(version);
//                            System.out.println(campaign);
//                            System.out.println(country);
//                            System.out.println(media_source);
//                            Integer count = phoenixJdbcTemplate.queryForObject("select count(1) from CLIENT_UPLOAD_INSTALL_EVENT where PACKAGE_NAME = '" + app + "' and VERSION = '" + version + "' and CAMPAIGN = '" + campaign + "' and COUNTRY = '" + country + "' and MEDIA_SOURCE = '" + media_source + "'", Integer.class);
//                            System.out.println(count);
//
//                            AndroidInstallCount androidInstallCount = new AndroidInstallCount();
//                            androidInstallCount.setCount(count);
//                            androidInstallCount.setDate(DateUtil.getYMDDate("2019-02-11"));
//                            androidInstallCount.setApp(app);
//                            androidInstallCount.setVersion(version);
//                            androidInstallCount.setCampaign(campaign);
//                            androidInstallCount.setCountry(country);
//                            androidInstallCount.setMediaSource(media_source);
//                            androidInstallCountMapper.insertSelective(androidInstallCount);
//                        }
//                    }
//                }
//            }
//        }
//
//
//    }

    @Test
    public void testPhoeinx(){
        int i = testPhoenix.testPhoenix();
        System.out.println(i);
    }

    @Test
    public void testMysql(){
        AndroidInstallCount androidInstallCount = androidInstallCountMapper.selectByPrimaryKey(2L);
        System.out.println(androidInstallCount);
    }

}

