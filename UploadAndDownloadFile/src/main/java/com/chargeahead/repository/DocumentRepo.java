package com.chargeahead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.chargeahead.entity.Document;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {
	
	
	
	
	

}
