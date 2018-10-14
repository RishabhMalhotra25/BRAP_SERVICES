package com.example.upload.controller;


import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.upload.entity.Upload;
import com.example.upload.repository.UploadRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/upload")
@Api(value = "Guidelines", description = "Describes the guidelines for " +
        " Spring boot 2.0.1 for uploading large file using Swagger UI")
public class FileUploadRestApi {

	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(FileUploadRestApi.class);
	
	 @Autowired
	    private UploadRepository uploadRepository;

    @PostMapping
    @ApiOperation(value = "Make a POST request to upload the file",
            produces = "application/json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The POST call is Successful"),
            @ApiResponse(code = 500, message = "The POST call is Failed"),
            @ApiResponse(code = 404, message = "The API could not be found")
    })
    public ResponseEntity<String> uploadFile(
			@RequestParam("fileId") Long fileId,@RequestParam("fileName") String fileName, @ApiParam(name = "file", value = "Select the file to Upload", required = true)
            @RequestPart("file") MultipartFile file,@RequestParam("fileDescription") String fileDescription,@RequestParam("fileUploadUserId") String userID) throws IOException {
    	logger.info("Start------------------------------------------");
		Upload upload = new Upload();
		upload.setContent(file.getBytes());
		
		upload.setId(fileId);
		upload.setTitle(fileName);
		upload.setFileDescription(fileDescription);
		
		upload.setFileUploadDate(new Date());
		upload.setFileUploadUserID(userID);
		
		Upload todoItem = uploadRepository.save(upload);
		logger.info("------------------------------------------End");

		return new ResponseEntity<String>("Done", HttpStatus.OK);
	}
}