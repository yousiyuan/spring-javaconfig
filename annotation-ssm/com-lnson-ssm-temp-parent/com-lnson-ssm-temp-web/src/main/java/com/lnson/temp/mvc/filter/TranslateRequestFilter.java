package com.lnson.temp.mvc.filter;

import com.lnson.temp.util.commons.CustomHttpServletRequestWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义Filter过滤器，用于传输请求
 *
 * 这个过滤器的作用：所有的post请求中的body参数是已流形式存在的，而流数据只能读取一次，如果在拦截器中需要对post参数进行处理的话，
 * 就会报Required request body is missing 异常。在此，我们使用ContentCachingRequestWrapper来解决该问题！
 */
@Order(value = 1)
@WebFilter(filterName = "translateRequestFilter", urlPatterns = {"/webapi/*"})
public class TranslateRequestFilter implements Filter {

    private final static Logger logger = LogManager.getLogger(TranslateRequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        //CustomHttpServletRequestWrapper requestWrapper = new CustomHttpServletRequestWrapper(((HttpServletRequest) servletRequest));
        logger.debug("过滤器");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }
}
