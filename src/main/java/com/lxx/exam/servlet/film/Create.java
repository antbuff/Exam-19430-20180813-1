package com.lxx.exam.servlet.film;

import com.lxx.exam.dao.FilmDao;
import com.lxx.exam.dao.LanguageDao;
import com.lxx.exam.dao.impl.FilmDaoImpl;
import com.lxx.exam.dao.impl.LanguageDaoImpl;
import com.lxx.exam.domain.Film;
import com.lxx.exam.domain.Language;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Create extends HttpServlet {

    private LanguageDao languageDao = new LanguageDaoImpl();
    private FilmDao filmDao = new FilmDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Language> languages = languageDao.listAll();
        req.setAttribute("languages", languages);
        req.getRequestDispatcher("/html/jsp/film/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int languageId = Integer.parseInt(req.getParameter("languageId"));
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
        filmDao.create(film);
        int count = filmDao.count();
        int lastpage = (int) Math.ceil(count * 1.0 / 20);
        resp.sendRedirect("/film/list.html?page="+lastpage);
    }
}

