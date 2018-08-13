package com.lxx.exam.dao;

import com.lxx.exam.bean.FilmXLanguage;

import java.util.List;

public interface FilmXLanguageDao {
    public List<FilmXLanguage> list(int start, int offset);
    public FilmXLanguage find(int fid);
}
