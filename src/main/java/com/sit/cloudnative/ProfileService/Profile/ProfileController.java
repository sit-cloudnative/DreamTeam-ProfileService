package com.sit.cloudnative.ProfileService.Profile;

import java.util.List;

import com.sit.cloudnative.ProfileService.Favorite.Favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * GET /profile/favorite/{id}
 * POST /profile/favorite
 * DELETE /profile/favorite
 */
@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;
    
    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getAllProfile(){
        return new ResponseEntity<List<Profile>>(profileService.getAllProfile(),HttpStatus.OK);
    }

    @PostMapping("/profile")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        System.out.println(profile.toString());
        return new ResponseEntity<Profile>(profileService.createProfile(profile),HttpStatus.OK);
    }

    @DeleteMapping("/profile/{id}")
        public ResponseEntity<Profile> deleteProfile(@PathVariable("id") long id ){
        return new ResponseEntity<Profile>(profileService.deleteProfileById(id),HttpStatus.OK);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") long id ){
        return new ResponseEntity<Profile>(profileService.getProfileById(id),HttpStatus.OK);        
    }

    @PostMapping("/profile/favorite/{id}")
    public ResponseEntity<Profile> createFavoriteByProfileId(@PathVariable("id") long id,@RequestBody Favorite favorite ){
        return new ResponseEntity<Profile>(profileService.addFavoriteByPrifileId(id, favorite),HttpStatus.OK);        
    }

    @DeleteMapping("/profile/favorite/{id}")
    public ResponseEntity<Profile> deleteFavoriteByProfileId(@PathVariable("id") long id){
        return new ResponseEntity<Profile>(profileService.deleteFavoriteByPrifileId(id),HttpStatus.OK);        
    }

    }