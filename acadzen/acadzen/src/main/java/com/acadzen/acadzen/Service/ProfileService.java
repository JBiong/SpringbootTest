package com.acadzen.acadzen.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acadzen.acadzen.Entity.ProfileEntity;
import com.acadzen.acadzen.Repository.ProfileRepository;

@Service
public class ProfileService {
    
    @Autowired
    ProfileRepository prepo;

    public ProfileEntity insertProfile(ProfileEntity profile){
        return prepo.save(profile);
    }

    public List<ProfileEntity> getAllProfile(){
        return prepo.findAll();
    }

    @SuppressWarnings("finally")
    public ProfileEntity udpateProfile(int profid, ProfileEntity newProfileDetails){
        ProfileEntity profile = new ProfileEntity();

        try{
            profile = prepo.findById(profid).get();

            profile.setFirstname(newProfileDetails.getFirstname());
            profile.setLastname(newProfileDetails.getLastname());
            profile.setGender(newProfileDetails.getGender());
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException("Profile " + profid + " does not exist!");
        }
        finally{
            return prepo.save(profile);
        }
    }

    public String deleteProfile(int profid){
        String msg = "";

        if (prepo.findById(profid) != null) {
            prepo.deleteById(profid);
            msg = "Profile " + profid + " is successfully deleted";
        }
        else{
            msg = "Profile " + profid + " does not exist";
        }
        return msg;
    }
}
