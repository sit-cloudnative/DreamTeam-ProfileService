package com.sit.cloudnative.ProfileService.Profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class ProfileService {

  @Autowired
  ProfileRepository profileRepo;

  public List<Profile> getAllProfile(){
    return profileRepo.findAll();
  }

  public Profile getProfileById(long id){
    return profileRepo.getOne(id);
  }

  public void deleteProfileById(Profile profile){
    profileRepo.delete(profile);
  }

  public Profile createProfile(Profile profile){
    return profileRepo.save(profile);
  }

}