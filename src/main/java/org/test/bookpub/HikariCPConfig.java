package org.test.bookpub;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by user on 2016/9/11.
 */
@Configuration
@PropertySource("classpath:db.properties")
public class HikariCPConfig {

    @Value("${HikariCP.datasource.username}")
    private String user;

    @Value("${HikariCP.datasource.password}")
    private String password;

    @Value("${HikariCP.datasource.jdbcUrl}")
    private String dataSourceUrl;

    @Value("${HikariCP.datasource.dataSourceClassName}")
    private String dataSourceClassName;

    @Value("${HikariCP.datasource.connectionTimeout}")
    private int connectionTimeout;

    @Value("${HikariCP.datasource.maxLifetime}")
    private int maxLifetime;

    @Value("${HikariCP.datasource.maximumPoolSize}")
    private int maximumPoolSize;

    @Value("${HikariCP.datasource.minimumIdle}")
    private int minimumIdle;
//
    @Value("${HikariCP.datasource.idleTimeout}")
    private int idleTimeout;

    @Value("${HikariCP.datasource.autoCommit}")
    private boolean autoCommit;

    @Value("${HikariCP.datasource.readOnly}")
    private boolean readOnly;

    @Bean(destroyMethod = "close",name = "hikariDataSource")
    public DataSource primaryDataSource() {
        Properties configProps = new Properties();
        configProps.put("dataSourceClassName", dataSourceClassName);
        configProps.put("username", user);
        configProps.put("password", password);
        configProps.put("jdbcUrl", dataSourceUrl);
        configProps.put("maximumPoolSize",maximumPoolSize);
        configProps.put("minimumIdle",minimumIdle);
        configProps.put("connectionTimeout", connectionTimeout);
        configProps.put("idleTimeout", idleTimeout);
        configProps.put("readOnly", readOnly);
        configProps.put("autoCommit", autoCommit);
        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource(hc);
        return ds;
    }

}
