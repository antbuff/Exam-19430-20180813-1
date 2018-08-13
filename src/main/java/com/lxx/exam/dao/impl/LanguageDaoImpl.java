package com.lxx.exam.dao.impl;

import com.lxx.exam.dao.LanguageDao;
import com.lxx.exam.domain.Language;
import com.lxx.exam.util.DBUtil;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDaoImpl implements LanguageDao {

    private Connection conn;
    private PreparedStatement pstat;
    private Statement stat;
    private ResultSet rs;

    @Override
    public List<Language> listAll() {
        ArrayList<Language> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select language_id,name,last_update from language";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()){
                Language lg = rs2lg(rs);
                list.add(lg);
            }
            rs.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Language rs2lg(ResultSet rs){
        Language language = new Language();
        try {
            language.setLanguageId(rs.getInt("language_id"));
            language.setName(rs.getString("name"));
            language.setLastUpdate(rs.getDate("last_update"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return language;
    }
}
