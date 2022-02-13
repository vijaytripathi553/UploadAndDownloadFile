package com.chargeahead.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chargeahead.entity.Document;
import com.chargeahead.repository.DocumentRepo;
import com.chargeahead.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService
{
	
	@Autowired
	private DocumentRepo documentRepo;

	@Override
	public Document saveFile(MultipartFile file) {
		String fileName=file.getOriginalFilename();
		try
		{
			Document doc=new Document(fileName,file.getContentType(),file.getBytes(),new Date());
			
			return documentRepo.save(doc);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return null;  // If error occurs then will return null
	}
	
	
	// Method to display/find file by document id
	@Override
	public Optional<Document> getFile(int id) {
		
		return documentRepo.findById(id);
	}


	// This method id cretaed to list out all the documents that we have in our database
	@Override
	public List<Document> getAllFiles() {
		return documentRepo.findAll();
	}
	
}
