package com.acadzen.acadzen.Controller;

import com.acadzen.acadzen.Entity.ProfileEntity;
import com.acadzen.acadzen.Entity.UserEntity;
import com.acadzen.acadzen.Repository.ProfileRepository;
import com.acadzen.acadzen.Repository.UserRepository;
import com.acadzen.acadzen.Service.ProfileService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserRepository urepo;

    @Autowired
    private ProfileRepository prepo;

    // @PostMapping("/save")
    // public ProfileEntity saveProfile(@RequestBody ProfileEntity profile) {
    //     return profileService.saveProfile(profile);
    // }

    // @GetMapping("/{id}")
    // public ProfileEntity getProfile(@PathVariable int id) {
    //     return profileService.getProfile(id);
    // }

    // @PutMapping("/update")
    // public ProfileEntity updateProfile(@RequestBody ProfileEntity profile) {
    //     return profileService.updateProfile(profile);
    // }

    // @GetMapping("/user/{userno}")
    // public ProfileEntity getProfileByUserno(@PathVariable int userno) {
    //     return profileService.getProfileByUserno(userno);
    // }

    @PostMapping("/uploadProfilePicture")
    public ProfileEntity uploadProfilePicture(@RequestParam("userno") int userno, @RequestParam("file") MultipartFile file) {
    byte[] profilePicture = null;
    try {
        profilePicture = file.getBytes();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return profileService.saveProfilePicture(userno, profilePicture);
    }

    @GetMapping("/getProfilePicture/{userno}")
    public byte[] getProfilePicture(@PathVariable int userno) {
        UserEntity user = urepo.findById(userno).orElse(null);
        ProfileEntity profile = prepo.findByUser(user);
        return profile != null ? profile.getProfilePicture() : null;
    }


    // other controller methods
}
