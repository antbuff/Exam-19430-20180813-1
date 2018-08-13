package com.lxx.exam.servlet.customer;

import com.lxx.exam.dao.CustomerDao;
import com.lxx.exam.dao.impl.CustomerDaoImpl;
import com.lxx.exam.domain.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {

    private CustomerDao ctDao = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/jsp/customer/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        Customer ct = ctDao.find(firstName);
        if(ct == null){
            resp.sendError(400,"用户不存在！");
        }else{
            resp.setStatus(200);
            Cookie cookie = new Cookie("id", ct.getCustomerId().toString());
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/");
            resp.addCookie(cookie);
            resp.sendRedirect("/index.html");
        }
    }
}
