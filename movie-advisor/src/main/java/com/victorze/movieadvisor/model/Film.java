package com.victorze.movieadvisor.model;

import java.util.List;
import java.util.Objects;

public class Film {
	
	private long id;
	private String title;
	private List<String> genres;
	private String year;
	
	public Film() { }
	
	public Film(long id, String title, String year, List<String> genres) {
		this.id = id;
		this.title = title;
		this.genres = genres;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genres, id, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(genres, other.genres) && id == other.id && Objects.equals(title, other.title)
				&& Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", genres=" + genres + ", year=" + year + "]";
	}

}
