package com.victorze.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.victorze.movieadvisor.config.AppConfig;
import com.victorze.movieadvisor.model.Film;

@Repository
public class FilmDaoImplMemory implements FilmDao {

	public List<Film> peliculas = new ArrayList<>();

	@Autowired
	private AppConfig appConfig;
	
	@PostConstruct
	public void init() {
		peliculas = UtilFilmFileReader.readFile(
										appConfig.getFile(),
										appConfig.getSeparator(),
										appConfig.getListSeparator());
	}

	@Override
	public Film findById(long id) {
		Optional<Film> result = peliculas
									.stream()
									.filter(f -> f.getId() == id)
									.findFirst();
		return result.orElse(null);
	}

	@Override
	public Collection<Film> findAll() {
		return peliculas;
	}

	@Override
	public void insert(Film film) {
		peliculas.add(film);
	}

	@Override
	public void edit(Film film) {
		int index = getIndexOf(film.getId());
		if (index != -1) {
			peliculas.set(index, film);
		}
	}

	@Override
	public void delete(long id) {
		int index = getIndexOf(id);
		if (index != -1) {
			peliculas.remove(index);
		}
	}
	
	private int getIndexOf(long id) {
		boolean found = false;
		int index = 0;
		
		while (!found && index < peliculas.size()) {
			if (peliculas.get(index).getId() == id) {
				found = true;
			} else {
				index++;
			}
		}

		return found? index : -1;
	}

}
