package com.acadzen.acadzen.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblprofile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profid;

    // Add the foreign key relationship
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userno", referencedColumnName = "userno")
    private UserEntity user;

    private String firstname;
    private String lastname;
    private String gender;

    // Default constructor
    public ProfileEntity() {}

    // Constructor without profid, as it's generated by the database
    public ProfileEntity(UserEntity user, String firstname, String lastname, String gender) {
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    // Getters and setters
    public int getProfid() {
        return profid;
    }

    public void setProfid(int profid) {
        this.profid = profid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
