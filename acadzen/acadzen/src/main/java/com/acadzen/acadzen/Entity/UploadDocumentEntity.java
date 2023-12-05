package com.acadzen.acadzen.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbldocument")
public class UploadDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int documentID;
    @Column(name = "docTitle")
    private String documentTitle;
    private String fileType;
    @Lob
    private byte[] fileContent;
    private String fileSize;
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "userno")
    private UserEntity user;

    
    public UserEntity getUser() {
        return user;
    }


    public void setUser(UserEntity user) {
        this.user = user;
    }


    public UploadDocumentEntity() {

    }


    public UploadDocumentEntity(int documentID, String documentTitle, String fileType, byte[] fileContent,
            String fileSize) {
        this.documentID = documentID;
        this.documentTitle = documentTitle;
        this.fileType = fileType;
        this.fileContent = fileContent;
        this.fileSize = fileSize;
        this.isDeleted = false;
    }


    public int getDocumentID() {
        return documentID;
    }


    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }


    public String getDocumentTitle() {
        return documentTitle;
    }


    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }


    public String getFileType() {
        return fileType;
    }


    public void setFileType(String fileType) {
        this.fileType = fileType;
    }


    public byte[] getFileContent() {
        return fileContent;
    }


    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }


    public String getFileSize() {
        return fileSize;
    }


    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}
