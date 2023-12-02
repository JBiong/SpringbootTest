package com.acadzen.uploadDocument.Controller;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.acadzen.uploadDocument.Entity.UploadDocumentEntity;
import com.acadzen.uploadDocument.Service.UploadDocumentService;

@RestController
@RequestMapping("/api/document")
@CrossOrigin(origins = "http://localhost:3000")
public class UploadDocumentController {

    @Autowired
    UploadDocumentService dserv;

    @PostMapping("/upload")
    public ResponseEntity<UploadDocumentEntity> insertDocument(@RequestPart("document") UploadDocumentEntity document, @RequestPart("file") MultipartFile file) throws IOException {

        try {
            UploadDocumentEntity savedDocument = dserv.insertDocument(document, file);
            return ResponseEntity.ok(savedDocument);
        } catch (MaxUploadSizeExceededException e) {
            // Handle file size exceeded error
            return ResponseEntity.status(413).build(); // 413 Request Entity Too Large
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<UploadDocumentEntity>> getAllDocuments() {
    List<UploadDocumentEntity> uploadedFiles = dserv.getAllDocuments(); // Implement this method in your service
    return ResponseEntity.ok(uploadedFiles);
}

    
    @PutMapping("/update/{documentID}")
    public ResponseEntity<UploadDocumentEntity> updateDocument(@PathVariable int documentID, @RequestParam(name = "file", required = false) MultipartFile newFile, @RequestPart("document") UploadDocumentEntity newUploadDocumentEntity) {
        UploadDocumentEntity updatedDocument = dserv.updateDocument(documentID, newFile, newUploadDocumentEntity);
        return ResponseEntity.ok(updatedDocument);
}


}


// @PutMapping("/update")
    // public UploadDocumentEntity updateDocument(@RequestParam int documentID, @RequestBody UploadDocumentEntity newUploadDocumentEntity) {
    //     return dserv.updateDocument(documentID);
    // }

//     @PutMapping("/update/{documentID}")
// public UploadDocumentEntity updateDocument(@PathVariable int documentID, @RequestParam(name = "file", required = false) MultipartFile newFile, @RequestPart("document") UploadDocumentEntity newUploadDocumentEntity) {
//     return dserv.updateDocument(documentID);
// }