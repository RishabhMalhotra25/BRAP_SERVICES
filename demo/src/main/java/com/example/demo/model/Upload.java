package com.example.demo.model;

import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "UPLOAD")
public class Upload {

	
	@Id
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "TITLE", nullable = false)
	private String title;

	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="SCRIPT_FILE", nullable=false)
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
