package com.chargeahead.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document {
	
	// Private data members
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String docName;
	
	private String docType;
	
	private Date createdOn;
	
	//private byte[] data;
	
	
	// Default Constructor
	
	

	public Document()
	{
		System.out.println("Internally this method will be called by the compiler. No Matter whether default constructor is created or not.");
	}
	
	// Parameterized Constructor
	public Document( String docName, String docType, byte data[],Date createdOn )
	{
		this.docName=docName;
		this.docType=docType;
		this.createdOn=createdOn;
		
	}

	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/*
	 * public byte[] getData() { return data; }
	 * 
	 * public void setData(byte[] data) { this.data = data; }
	 */

}
