package com.example.springboothadoophbase.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.springboothadoophbase.dao.hive", sqlSessionTemplateRef  = "hiveSqlSessionTemplate")
public class HiveDataSourceConfiguration {

    @Bean(name = "hiveDataSource")
    //下面这个注解控制哪个实例优先被注入，我们放在第一个数据源上面
    @ConfigurationProperties(prefix = "spring.datasource.hive")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean(name = "hiveSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hiveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "hiveTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("hiveDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "hiveSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("hiveSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
             {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}