package com.lxx.exam.dao.impl;

import com.lxx.exam.dao.FilmDao;
import com.lxx.exam.domain.Film;
import com.lxx.exam.util.DBUtil;

import java.sql.*;

public class FilmDaoImpl implements FilmDao {

    private Connection conn;
    private PreparedStatement pstat;
    private Statement stat;
    private ResultSet rs;

    @Override
    public Film find(int id) {
        Film film=null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select film_id,title,description,release_year,language_id,original_language_id,rental_duration,rental_rate,length,replacement_cost,rating,special_features,last_update from film where film_id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,id);
            rs = pstat.executeQuery();
            if(rs.next()){
                film = rs2film(rs);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void create(Film film) {
        String sql = "insert into film(title,description,language_id) values(?,?,?)";
        try {
            conn = DBUtil.getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,film.getTitle());
            pstat.setString(2,film.getDescription());
            pstat.setInt(3,film.getLanguageId());
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from film where film_id = ?";
        try {
            conn = DBUtil.getConnection();
            pstat= conn.prepareStatement(sql);
            pstat.setInt(1,id);
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Film film) {
        String sql = "update film set title=?,description=?,language_id=? where film_id = ?";
        try {
            conn = DBUtil.getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,film.getTitle());
            pstat.setString(2,film.getDescription());
            pstat.setInt(3,film.getLanguageId());
            pstat.setInt(4,film.getFilmId());
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int count() {
        int count = 0;
        try {
            String sql = "select count(1) from film";
            conn = DBUtil.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                count = rs.getInt(1);
            }
            rs.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private Film rs2film(ResultSet rs) {
        Film film = new Film();
        try {
            film.setFilmId(rs.getInt("film_id"));
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            film.setReleaseYear(rs.getInt("release_year"));
            film.setLanguageId(rs.getInt("language_id"));
            film.setOriginalLanguageId(rs.getInt("original_language_id"));
            film.setRentalDuration(rs.getInt("rental_duration"));
            film.setRentalRate(rs.getDouble("rental_rate"));
            film.setLength(rs.getInt("length"));
            film.setReplacementCost(rs.getDouble("replacement_cost"));
            film.setRating(rs.getString("rating"));
            film.setSpecialFeatures(rs.getString("special_features"));
            film.setLastUpdate(rs.getDate("last_update"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

}
