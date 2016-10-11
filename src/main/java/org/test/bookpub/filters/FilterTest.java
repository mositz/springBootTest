package org.test.bookpub.filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by zhangxingxing on 16/9/12.
 */
@WebFilter("/**")
@Component
public class FilterTest implements Filter{

    private final Logger logger = LoggerFactory.getLogger(FilterTest.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info(filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
