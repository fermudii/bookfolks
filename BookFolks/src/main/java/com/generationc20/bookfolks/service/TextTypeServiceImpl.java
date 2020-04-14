package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.TextTypeRepository;
import com.generationc20.bookfolks.model.TextType;

@Service
public class TextTypeServiceImpl implements TextTypeService{

	@Autowired
	private TextTypeRepository repository;
	
	@Override
	public TextType save(TextType textType) {
		return repository.save(textType);
	}
	
	@Override
	public Optional<TextType> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public TextType update(Integer id, TextType textType) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
