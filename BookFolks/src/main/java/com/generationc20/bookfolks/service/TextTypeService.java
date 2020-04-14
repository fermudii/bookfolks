package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.TextType;

public interface TextTypeService {

	TextType save(TextType textType);
	Optional<TextType> getById(Integer id);
	TextType update(Integer id, TextType textType);
	void remove(Integer id);
}
