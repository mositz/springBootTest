package org.test.bookpub;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.test.bookpub.annotation.MapperType;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zhangxingxing on 16/9/12.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan
public class MyBatisConfig {

    private final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory(@Qualifier("hikariDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//       sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mappers/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager createDataSourceTransactionManager(@Qualifier("hikariDataSource") DataSource dataSource)
            throws SQLException {
        logger.info(dataSource.getConnection().toString());
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer= new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.test");
        mapperScannerConfigurer.setAnnotationClass(MapperType.class);
        return mapperScannerConfigurer;
    }
}
