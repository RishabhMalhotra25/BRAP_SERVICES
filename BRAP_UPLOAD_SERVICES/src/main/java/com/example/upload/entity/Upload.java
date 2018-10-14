package com.example.upload.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "BRAP_FILE_UPLOAD_INFO")
public class Upload {

	
	@Id
	@Column(name = "FILE_ID ", nullable = false)
	private Long id;
	
	@Column(name = "FILE_NAME ", nullable = false)
	private String title;
	
	@Column(name = "FILE_DESCRIPTION  ", nullable = false)
	private String fileDescription;
	
	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public Date getFileUploadDate() {
		return fileUploadDate;
	}

	public void setFileUploadDate(Date fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}

	public String getFileUploadUserID() {
		return fileUploadUserID;
	}

	public void setFileUploadUserID(String fileUploadUserID) {
		this.fileUploadUserID = fileUploadUserID;
	}

	@Column(name = "UPLOADED_DATE  ", nullable = false)
	private Date fileUploadDate;
	
	@Column(name = "UPLOADED_USER_ID   ", nullable = false)
	private String fileUploadUserID;
	 
	
	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="FILE_OBJECT ", nullable=false)
    private byte[] content;
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	
}
