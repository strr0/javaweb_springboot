package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/RegisterServlet")
public class NameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if(name == null){
            chain.doFilter(request, response);
            return;
        }
        else{
            String illegalName = request.getServletContext().getInitParameter("illegalName");
            int index = illegalName.indexOf(name);
            if(index != -1){
                out.println("非法名字");
                return;
            }
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
