package com.acadzen.acadzen.Service;

import com.acadzen.acadzen.Entity.ProfileEntity;
import com.acadzen.acadzen.Entity.UserEntity;
import com.acadzen.acadzen.Repository.ProfileRepository;
import com.acadzen.acadzen.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    // public ProfileEntity saveProfile(ProfileEntity profile) {
    //     return profileRepository.save(profile);
    // }

    // public ProfileEntity getProfile(int id) {
    //     return profileRepository.findById(id).orElse(null);
    // }

    // public ProfileEntity updateProfile(ProfileEntity profile) {
    //     return profileRepository.save(profile);
    // }

    // public ProfileEntity getProfileByUserno(int userno) {
    //     UserEntity user = userRepository.findById(userno).orElse(null);
    //     return profileRepository.findByUser(user);
    // }

    public ProfileEntity saveProfilePicture(int userno, byte[] profilePicture) {
        UserEntity user = userRepository.findById(userno).orElse(null);
        ProfileEntity profile = profileRepository.findByUser(user);
        if (profile == null) {
            profile = new ProfileEntity();
            profile.setUser(user);
        }
        profile.setProfilePicture(profilePicture);
        return profileRepository.save(profile);
    }
    
    // other service methods
}
