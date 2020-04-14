package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.Genre;


public interface GenreService {

	Genre save(Genre genre);
	Optional<Genre> getById(Integer id);
	Genre update(Integer id, Genre genre);
	void remove(Integer id);
}
