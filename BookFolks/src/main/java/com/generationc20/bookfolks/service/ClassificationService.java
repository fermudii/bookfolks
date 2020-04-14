package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.Classification;

public interface ClassificationService {

	Classification save(Classification classification);
	Optional<Classification> getById(Integer id);
	Classification update(Integer id, Classification classification);
	void remove(Integer id);
}
