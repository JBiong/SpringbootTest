package com.acadzen.acadzen.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acadzen.acadzen.Entity.UploadDocumentEntity;
import com.acadzen.acadzen.Entity.UserEntity;

@Repository
public interface UploadDocumentRepository extends JpaRepository<UploadDocumentEntity, Integer> {
    List<UploadDocumentEntity> findByIsDeletedFalse();
    List<UploadDocumentEntity> findByDocumentIDAndIsDeletedFalse(int documentID);
    List<UploadDocumentEntity> findByUserAndIsDeletedFalse(UserEntity user);
}
