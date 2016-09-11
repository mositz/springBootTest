package org.test.bookpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by user on 2016/9/11.
 */
/**
 * 获取命令行参数
 */
@Component
public class StartupRunner implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Autowired
    @Qualifier(value = "hikariDataSource")
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        logger.info(dataSource.toString());
        logger.info(Arrays.asList(args).toString());
    }
}
