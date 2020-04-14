package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.GenreRepository;
import com.generationc20.bookfolks.model.Genre;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository repository;
	
	@Override
	public Genre save(Genre genre) {
		return repository.save(genre);
	}
	
	@Override
	public Optional<Genre> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Genre update(Integer id, Genre genre) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}

