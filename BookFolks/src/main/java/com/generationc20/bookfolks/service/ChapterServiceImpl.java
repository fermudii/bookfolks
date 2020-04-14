package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.ChapterRepository;
import com.generationc20.bookfolks.model.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository repository;
	
	@Override
	public Chapter save(Chapter chapter) {
		return repository.save(chapter);
	}
	
	@Override
	public Optional<Chapter> getById(Integer id) {
		
		return repository.findById(id);
	}
	
	@Override
	public Chapter update(Integer id, Chapter chapter) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
