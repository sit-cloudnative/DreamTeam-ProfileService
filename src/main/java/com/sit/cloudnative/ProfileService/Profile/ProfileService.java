package com.sit.cloudnative.ProfileService.Profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class ProfileService {

  @Autowired
  ProfileRepository profileRepo;

  

}