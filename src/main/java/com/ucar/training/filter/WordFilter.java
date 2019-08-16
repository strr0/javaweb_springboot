package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@WebFilter("/MessageBoardServlet")
public class WordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
        System.out.println("过滤init");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper((HttpServletRequest)request){
            @Override
            public String getParameter(String name){
                String value = super.getParameter(name);
                if(value.contains("傻逼") || value.contains("白痴") || value.contains("操你妈")){
                    value = "**";
                }
                return value;
            }
        };
        chain.doFilter(wrapper, response);
    }
    @Override
    public void destroy() {
        //
        System.out.println("过滤destroy");
    }
}
