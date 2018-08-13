package com.lxx.exam.servlet.film;

import com.lxx.exam.bean.FilmXLanguage;
import com.lxx.exam.dao.FilmDao;
import com.lxx.exam.dao.FilmXLanguageDao;
import com.lxx.exam.dao.impl.FilmDaoImpl;
import com.lxx.exam.dao.impl.FilmXLanguageDaoImpl;
import com.lxx.exam.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class Select extends HttpServlet {

    private FilmXLanguageDao fxlDao = new FilmXLanguageDaoImpl();
    private FilmDao filmDao = new FilmDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int offset = 20;
        String spage = req.getParameter("page");
        String soffset = req.getParameter("offset");
        if(spage == null){
            page = 1;
        }else{
            page = Integer.parseInt(spage);
        }
        if(soffset == null){
            offset = 20;
        }else{
            offset = Integer.parseInt(soffset);
        }

        int size = filmDao.count();
        int pagesize = (int) Math.ceil(size*1.0/offset);

        if(page > pagesize){
            page = pagesize;
        }
        if(page<=0){
            page = 1;
        }

        Customer ct = (Customer) req.getAttribute("user");
        int start = (page-1)*offset;

        List<FilmXLanguage> list = fxlDao.list(start, offset);
        req.setAttribute("list",list);

        req.setAttribute("pagesize",pagesize);
        req.setAttribute("currentpage",page);


        req.getRequestDispatcher("/html/jsp/film/list.jsp").forward(req,resp);
    }
}
