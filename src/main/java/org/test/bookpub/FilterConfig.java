package org.test.bookpub;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.test.bookpub.PropertyBind.BookFormatter;
import org.test.bookpub.PropertyBind.Isbn;
import org.test.bookpub.PropertyBind.IsbnEditor;
import org.test.bookpub.filters.FilterTest;
import org.test.bookpub.repository.TestaaRepository;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangxingxing on 16/9/12.
 */
@Configuration
@ComponentScan
public class FilterConfig {

    private final Logger logger = LoggerFactory.getLogger(FilterConfig.class);

    @Autowired
    private TestaaRepository testaaRepository;

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        RemoteIpFilter remoteIpFilter =  new RemoteIpFilter();
        logger.info(remoteIpFilter.getRemoteIpHeader());
        return remoteIpFilter;
    }

    @Bean
    public FilterRegistrationBean getServletBean(FilterTest filterTest){
       FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filterTest);
        return filterRegistrationBean;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(LocaleChangeInterceptor localeChangeInterceptor) {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(localeChangeInterceptor);
                super.addInterceptors(registry);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                BookFormatter bookFormatter = new BookFormatter();
                bookFormatter.setTestaaRepository(testaaRepository);
                registry.addFormatter(bookFormatter);
                super.addFormatters(registry);
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/css/**").addResourceLocations("classpath:/public/");
                super.addResourceHandlers(registry);
            }


        };
    }

//        public WebApplicationInitializer getServletBean(){
//
//    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
       return container ->
               container.setSessionTimeout(1, TimeUnit.MINUTES);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }


//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        return tomcat;
//    }

}
