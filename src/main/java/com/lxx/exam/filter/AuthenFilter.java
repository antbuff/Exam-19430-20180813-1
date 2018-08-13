package com.lxx.exam.filter;

import com.lxx.exam.dao.CustomerDao;
import com.lxx.exam.dao.impl.CustomerDaoImpl;
import com.lxx.exam.domain.Customer;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        try {
            boolean flag_login = false;
            String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
            if (requestURI.equals("/user/login.html") || requestURI.equals("/user/login")){
                flag_login = true;
            }
            Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
            boolean flag = false;
            String key = "id";
            String value = "";
            if(cookies!=null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(key)) {
                        flag = true;
                        value = cookies[i].getValue();
                    }
                }
            }
            if (flag){
                CustomerDao ct = new CustomerDaoImpl();
                Customer customer = ct.find(Integer.parseInt(value));
                servletRequest.setAttribute("user",customer);
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                if (flag_login){
                    filterChain.doFilter(servletRequest,servletResponse);
                }else{
                    ((HttpServletResponse)servletResponse).sendRedirect("/user/login.html");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
