package com.acadzen.acadzen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acadzen.acadzen.Entity.ProfileEntity;
import com.acadzen.acadzen.Service.ProfileService;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {
    
    @Autowired
    ProfileService pserv;

    @PostMapping("/insertProfile")
    public ProfileEntity inserProfile(@RequestBody ProfileEntity profile){
        return pserv.insertProfile(profile);
    }

    @GetMapping("/getAllProfile")
    public List<ProfileEntity> getAllProfile(){
        return pserv.getAllProfile();
    }

    @PutMapping("/update/{profid}")
    public ProfileEntity updateProfile(@RequestBody int profid, @RequestBody ProfileEntity newProfileDetails){
        return pserv.udpateProfile(profid, newProfileDetails);
    }

    @DeleteMapping("/delete/{profid}")
    public String deleteProfile(@PathVariable int profid){
        return pserv.deleteProfile(profid);
    }
}
