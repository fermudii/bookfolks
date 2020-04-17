package com.generationc20.bookfolks.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.generationc20.bookfolks.dao.StoryRepository;
import com.generationc20.bookfolks.model.Story;

@Service
public class StoryServiceImpl implements StoryService{

	@Autowired
	private StoryRepository repository;
	
	@Autowired
	private StorageService storageService;
	
	@Override
	public Story save(Story story, MultipartFile multipartFile) {
		String url= null;
		try {
			url = storageService.uploadFile(multipartFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		story.setUrlImage(url);
		return repository.save(story);
		}
	
	@Override
	public List<Story> getAll() {
		return repository.findAll();
		}
	
	@Override
	public Optional<Story> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Story update(Integer id, Story story) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
