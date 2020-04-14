package com.generationc20.bookfolks.service;

import java.util.List;
import java.util.Optional;

import com.generationc20.bookfolks.model.Chapter;

public interface ChapterService {

	Chapter save(Chapter chapter);
	List<Chapter> getAll();
	Optional<Chapter> getById(Integer id);
	Chapter update(Integer id, Chapter chapter);
	void remove(Integer id);
}
