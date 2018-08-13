package com.lxx.exam.servlet.film;

import com.lxx.exam.dao.FilmDao;
import com.lxx.exam.dao.LanguageDao;
import com.lxx.exam.dao.impl.FilmDaoImpl;
import com.lxx.exam.dao.impl.LanguageDaoImpl;
import com.lxx.exam.domain.Film;
import com.lxx.exam.domain.Language;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Update extends HttpServlet {

    private FilmDao filmDao= new FilmDaoImpl();
    private LanguageDao languageDao = new LanguageDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String backurl = req.getParameter("backurl");
        Cookie cookie = new Cookie("backurl", backurl);
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        Film film = filmDao.find(id);
        List<Language> languages = languageDao.listAll();
        req.setAttribute("film",film);
        req.setAttribute("languages",languages);
        req.getRequestDispatcher("/html/jsp/film/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int filmId = Integer.parseInt(req.getParameter("filmId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int languageId = Integer.parseInt(req.getParameter("languageId"));
        Film film = new Film();
        film.setFilmId(filmId);
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
        filmDao.update(film);

        String backurl="/film/list.html";
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("backurl")){
                backurl = cookies[i].getValue();
            }
        }

        Cookie cookie = new Cookie("backurl", null);
        cookie.setMaxAge(0);
        resp.sendRedirect(backurl);


    }
}
