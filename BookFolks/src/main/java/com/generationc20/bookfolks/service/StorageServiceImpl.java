package com.generationc20.bookfolks.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class StorageServiceImpl implements StorageService{

	@Autowired
	private Storage storage;
	
	@Override
	@SuppressWarnings("deprecation")
	public String uploadFile(MultipartFile multipartFile) throws IOException {
		
		Timestamp fecha = new Timestamp(new Date().getTime());
		
		BlobInfo blobInfo=
				storage.create(
						BlobInfo
						.newBuilder("bookfolks",String.valueOf(fecha))
						.setAcl(new ArrayList<>(Arrays.asList(Acl.of(User.ofAllUsers(), Role.READER))))
						.build(),
						multipartFile.getInputStream());
				
		
		return blobInfo.getMediaLink();
	}
	
	
}
