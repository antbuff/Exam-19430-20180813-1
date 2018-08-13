package com.lxx.exam.dao;

import com.lxx.exam.domain.Film;

public interface FilmDao {
    public Film find(int id);
    public void create(Film film);
    public void delete(int id);
    public void update(Film film);
    public int count();
}
