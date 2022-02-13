package com.chargeahead.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chargeahead.entity.Document;
import com.chargeahead.service.DocumentService;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/")
	public String getFile(Model model)
	{
		List<Document> document=documentService.getAllFiles();
		model.addAttribute("document",document);
		
		return "document";
	}
	
	@PostMapping("uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files)
	{
		for(MultipartFile file:files)
		{
			documentService.saveFile(file);
			
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable int fileId, HttpServletRequest request)
	{
		 String contentType = null;
		 
		
		 Document doc=documentService.getFile(fileId).get();	
		 
		 try {
			   // Document doc=documentService.getFile(fileId).get();	
	            contentType = request.getServletContext().getMimeType(doc.getDocType());
	        } 
		 catch (Exception ex)
			{
				System.out.println("Could not determine file type."+ex.getMessage());
			}

		 // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
		
		
	        
	        
		//Document doc=documentService.getFile(fileId).get();	
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(contentType.getBytes()));
				
				
				}	
	
}
