package com.lxx.exam.servlet.film;

import com.lxx.exam.dao.FilmDao;
import com.lxx.exam.dao.impl.FilmDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Delete extends HttpServlet {

    private FilmDao filmDao = new FilmDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String backurl = req.getParameter("backurl");

        filmDao.delete(id);

        resp.sendRedirect(backurl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
