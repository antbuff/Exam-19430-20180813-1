package com.lxx.exam.dao.impl;

import com.lxx.exam.bean.FilmXLanguage;
import com.lxx.exam.dao.FilmXLanguageDao;
import com.lxx.exam.domain.Film;
import com.lxx.exam.domain.Language;
import com.lxx.exam.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmXLanguageDaoImpl implements FilmXLanguageDao {

    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rs;

    @Override
    public List<FilmXLanguage> list(int start, int offset) {
        ArrayList<FilmXLanguage> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select film_id,title,description,name from film,language where film.language_id=language.language_id limit ?,?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, start);
            pstat.setInt(2, offset);
            rs = pstat.executeQuery();
            while (rs.next()) {
                FilmXLanguage fxl = rs2fxl(rs);
                list.add(fxl);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public FilmXLanguage find(int fid) {
        FilmXLanguage fxl = null;
        try {
            String sql = "select film_id,title,description,name from film,language where film.language_id=language.language_id limit and film_id=?";
            conn = DBUtil.getConnection();
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            fxl = rs2fxl(rs);
            rs.close();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fxl;
    }

    private FilmXLanguage rs2fxl(ResultSet rs) {
        FilmXLanguage filmXLanguage = null;
        try {
            Film film = new Film();
            film.setFilmId(rs.getInt("film_id"));
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            Language language = new Language();
            language.setName(rs.getString("name"));
            filmXLanguage = new FilmXLanguage();
            filmXLanguage.setFilm(film);
            filmXLanguage.setLanguage(language);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmXLanguage;
    }
}
