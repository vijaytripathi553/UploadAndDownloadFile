package com.chargeahead.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.chargeahead.entity.Document;

public interface DocumentService {
	public Document saveFile(MultipartFile multipartFile);
	
	public Optional<Document> getFile(int id);
	
	public List<Document> getAllFiles();
	
	

}
