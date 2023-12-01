package com.acadzen.uploadDocument.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.acadzen.uploadDocument.Entity.UploadDocumentEntity;
import com.acadzen.uploadDocument.Repository.UploadDocumentRepository;

@Service
public class UploadDocumentService {
    
    @Autowired
    UploadDocumentRepository drepo;

    // Helper method to format file size
     private String formatFileSize(long size) {
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        double fileSize = size;

        while (fileSize > 1024 && unitIndex < units.length - 1) {
            fileSize /= 1024;
            unitIndex++;
        }

        return String.format("%.2f %s", fileSize, units[unitIndex]);
    }

    // Insert or upload a document file in tbldocument - Create
    public UploadDocumentEntity insertDocument(UploadDocumentEntity document, MultipartFile file) throws IOException {
    // Set file content as byte array
    document.setFileContent(file.getBytes());

    // Set document title (you can customize this based on your requirements)
    document.setDocumentTitle(file.getOriginalFilename());

    // Set file size
    document.setFileSize(formatFileSize(file.getSize()));

    return drepo.save(document);
}

    //Read all records in tbdocument - Read
    
    public List<UploadDocumentEntity> getAllDocuments() {
        return drepo.findAll();
    }


public UploadDocumentEntity updateDocument(int documentID, MultipartFile newFile, UploadDocumentEntity newUploadDocumentDetails) {
    // Find the existing document by documentID or throw an exception if not found
    UploadDocumentEntity document = drepo.findById(documentID)
            .orElseThrow(() -> new NoSuchElementException("Document " + documentID + " does not exist"));

    // Update document title based on newUploadDocumentDetails
    document.setDocumentTitle(newUploadDocumentDetails.getDocumentTitle());

    // If a new file is provided, update file content and size
    if (newFile != null) {
        try {
            document.setFileContent(newFile.getBytes());
            document.setFileSize(formatFileSize(newFile.getSize()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update file content.");
        }
    }

    // Save the updated document to the repository
    return drepo.save(document);
}


    // Delete the documennt file in tbldocument - Delete
    public void deleteDocument(int documentID) {
        drepo.deleteById(documentID);
    }

}

// Update document file in tbldocument - Update
    // @SuppressWarnings("finally")
    // public UploadDocumentEntity updateDocument(int documentID, UploadDocumentEntity newUploadDocumentDetails ) {
    //     UploadDocumentEntity document = new UploadDocumentEntity();
    //     try {
    //         document = drepo.findById(documentID).get();
    //         document.setDocumentTitle(newUploadDocumentDetails.getDocumentTitle());
    //         document.setFileContent(newUploadDocumentDetails.getFileContent());
    //     } catch(NoSuchElementException ex) {
    //         throw new NoSuchElementException("Document "+ documentID + "does not exist");
    //     } finally {
    //         return drepo.save(document);
    //     }
    // }]

    //@SuppressWarnings("finally")
// public UploadDocumentEntity updateDocument(int documentID, MultipartFile newFile, UploadDocumentEntity newUploadDocumentDetails) {
//     UploadDocumentEntity document = new UploadDocumentEntity();
//     try {
//         document = drepo.findById(documentID).orElseThrow(() -> new NoSuchElementException("Document " + documentID + " does not exist"));

//         document.setDocumentTitle(newUploadDocumentDetails.getDocumentTitle());

//         if (newFile != null) {
//             // Update file content and size if a new file is provided
//             document.setFileContent(newFile.getBytes());
//             document.setFileSize(formatFileSize(newFile.getSize()));
//         }
//     } catch (IOException e) {
//         // Handle IOException
//         throw new RuntimeException("Failed to update file content.");
//     } catch (NoSuchElementException ex) {
//         throw new NoSuchElementException("Document " + documentID + " does not exist");
//     } finally {
//         return drepo.save(document);
//     }
// }
// public UploadDocumentEntity updateDocument(int documentID, MultipartFile newFile, UploadDocumentEntity newUploadDocumentDetails ) {
//     UploadDocumentEntity document = drepo.findById(documentID).orElseThrow(() -> new NoSuchElementException("Document " + documentID + " does not exist"));

//     // Update document title
//     document.setDocumentTitle(newUploadDocumentDetails.getDocumentTitle());

//     if (newFile != null) {
//         try {
//             // Update file content if a new file is provided
//             document.setFileContent(newFile.getBytes());
//             document.setFileSize(formatFileSize(newFile.getSize()));
//         } catch (IOException e) {
//             // Handle IOException
//             e.printStackTrace();
//             throw new RuntimeException("Failed to update file content.");
//         }
//     }

//     return drepo.save(document);
// }