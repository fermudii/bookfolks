package com.generationc20.bookfolks.service;

import java.util.List;
import java.util.Optional;

import com.generationc20.bookfolks.model.Story;


public interface StoryService {

	Story save(Story story);
	List<Story> getAll();
	Optional<Story> getById(Integer id);
	Story update(Integer id, Story story);
	void remove(Integer id);
}
