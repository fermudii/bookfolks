package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.Chapter;

public interface ChapterService {

	Chapter save(Chapter chapter);
	Optional<Chapter> getById(Integer id);
	Chapter update(Integer id, Chapter chapter);
	void remove(Integer id);
}
