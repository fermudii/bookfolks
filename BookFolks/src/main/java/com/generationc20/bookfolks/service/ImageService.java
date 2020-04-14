package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.Image;


public interface ImageService {

	Image save(Image image);
	Optional<Image> getById(Integer id);
	Image update(Integer id, Image image);
	void remove(Integer id);
}
