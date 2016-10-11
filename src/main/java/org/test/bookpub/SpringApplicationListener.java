package org.test.bookpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by zhangxingxing on 16/7/4.
 */
public class SpringApplicationListener implements ApplicationListener<ApplicationPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(SpringApplicationListener.class);

    public void onApplicationEvent(ApplicationStartedEvent event) {
        logger.info(event.getSource().toString());
        logger.info(event.toString());
        logger.info("==MyApplicationStartedEventListener==");
    }

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        //获取应用上下文
    }
}


