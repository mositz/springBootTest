package org.test.bookpub;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by user on 2016/9/11.
 */
@SpringBootApplication
@EnableTransactionManagement
public class BookPubApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookPubApplication.class,args);
    }

   @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory(@Qualifier("hikariDataSource") DataSource dataSource){
       SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager createDataSourceTransactionManager(@Qualifier("hikariDataSource") DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer= new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.test");
        return mapperScannerConfigurer;
    }



}
