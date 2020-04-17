package com.generationc20.bookfolks.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.generationc20.bookfolks.dao.ChapterRepository;
import com.generationc20.bookfolks.model.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository repository;
	
	@Autowired
	private StorageService storageService;
	
	@Override
	public Chapter save(Chapter chapter,MultipartFile multipartFile) {
		
		String url= null;
		try {
			url = storageService.uploadFile(multipartFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		chapter.setUrlImage(url);
		return repository.save(chapter);
	}
	
	@Override
	public List<Chapter> getAll() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Chapter> getById(Integer id) {
		
		return repository.findById(id);
	}
	
	@Override
	public Chapter update(Integer id, Chapter chapter) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
