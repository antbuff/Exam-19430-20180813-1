package com.lxx.exam.bean;

import com.lxx.exam.domain.Film;
import com.lxx.exam.domain.Language;

public class FilmXLanguage {
    private Film film;
    private Language language;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
