package com.acadzen.acadzen.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblprofile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "userno", referencedColumnName = "userno")
    private UserEntity user;

    @Lob
    private byte[] profilePicture;

    public ProfileEntity() {
    }

    public ProfileEntity(int id, UserEntity user, byte[] profilePicture) {
        this.id = id;
        this.user = user;
        this.profilePicture = profilePicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    // getters and setters
    
}