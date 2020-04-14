package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.ImageRepository;
import com.generationc20.bookfolks.model.Image;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository repository;
	
	@Override
	public Image save(Image image) {
		return repository.save(image);
	}
	
	@Override
	public Optional<Image> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Image update(Integer id, Image image) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
