package com.example.productsearchsystem.Controller;

import com.example.productsearchsystem.Service.UpLoadFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1")
public class UpLoadController {

    UpLoadFileService upLoadFileService;

    public UpLoadController(UpLoadFileService upLoadFileService) {
        this.upLoadFileService = upLoadFileService;
    }

    @PostMapping("upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        try{
            return new ResponseEntity<>(upLoadFileService.uploadFile(file), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
