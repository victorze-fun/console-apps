package com.victorze.movieadvisor.service;

import java.util.Collection;

import com.victorze.movieadvisor.model.Film;

public interface FilmQueryService {
	
	Collection<Film> exec();
	FilmQueryService anyGenre(String... genres);
	FilmQueryService allGenres(String... genres);
	FilmQueryService year(String year);
	FilmQueryService betweenYears(String from, String to);
	FilmQueryService titleContains(String title);

}
