package com.acadzen.uploadDocument.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acadzen.uploadDocument.Entity.UploadDocumentEntity;

@Repository
public interface UploadDocumentRepository extends JpaRepository<UploadDocumentEntity, Integer>{
    
}
