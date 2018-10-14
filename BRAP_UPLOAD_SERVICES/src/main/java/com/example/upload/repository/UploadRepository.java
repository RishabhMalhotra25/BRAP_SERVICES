package com.example.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.upload.entity.Upload;

public interface UploadRepository extends JpaRepository<Upload, String> {


}
