package com.acadzen.acadzen.Repository;

import com.acadzen.acadzen.Entity.ProfileEntity;
import com.acadzen.acadzen.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {
    ProfileEntity findByUser(UserEntity user);
}
