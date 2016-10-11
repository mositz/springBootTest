package org.test.bookpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by user on 2016/9/11.
 */
@SpringBootApplication
public class BookPubApplication {

    private final Logger logger = LoggerFactory.getLogger(BookPubApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookPubApplication.class,args);
    }

}
