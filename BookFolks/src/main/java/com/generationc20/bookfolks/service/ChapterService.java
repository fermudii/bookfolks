package com.generationc20.bookfolks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.generationc20.bookfolks.model.Chapter;

public interface ChapterService {

	Chapter save(Chapter chapter/*,MultipartFile multipartFile*/);
	List<Chapter> getAll();
	Optional<Chapter> getById(Integer id);
	Chapter update(Integer id, Chapter chapter);
	void remove(Integer id);
}
