package com.victorze.movieadvisor.dao;

import java.util.Collection;

import com.victorze.movieadvisor.model.Film;

public interface FilmDao {

	Film findById(long id);
	Collection<Film> findAll();
	void insert(Film film);
	void edit(Film film);
	void delete(long id);

}
