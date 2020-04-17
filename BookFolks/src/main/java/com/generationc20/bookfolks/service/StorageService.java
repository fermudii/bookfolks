package com.generationc20.bookfolks.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	String uploadFile(MultipartFile multipartFile) throws IOException; 
}
