package com.sit.cloudnative.ProfileService.Profile;

import java.util.List;
import java.util.Optional;

import com.sit.cloudnative.ProfileService.Favorite.Favorite;

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
    return profileRepo.findByStudentId(id);
  }

  public Profile deleteProfileById(long id){
    Profile targetProfile = getProfileById(id);
    profileRepo.delete(targetProfile);
    return targetProfile;
  }

  public Profile createProfile(Profile profile){
    return profileRepo.save(profile);
  }

  public Profile addFavoriteByPrifileId(long profileId,Favorite favorite){
    Profile profile = getProfileById(profileId);
    List<Favorite> favorites = profile.getFavoriteSubject();
    favorites.add(favorite);
    profile.setFavoriteSubject(favorites);
    createProfile(profile);
    return profile;
  }

  public Profile deleteFavoriteByPrifileId(long profileId){
    Profile profile = getProfileById(profileId);
    List<Favorite> favorites = profile.getFavoriteSubject();
    favorites.remove(profile);
    profile.setFavoriteSubject(favorites);
    createProfile(profile);
    return profile;
  }

}