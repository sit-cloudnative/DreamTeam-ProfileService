package com.sit.cloudnative.ProfileService.Favorite;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * GET /profile/favorite/{id}
 * POST /profile/favorite
 * DELETE /profile/favorite
 */
@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorite/{studentId}")
    public ResponseEntity<List<Favorite>> getFavoriteById(@PathVariable long studentId){
        List<Favorite> stuFavorite = favoriteService.getFavoriteByStudentId(studentId);
        return new ResponseEntity<List<Favorite>>(stuFavorite,HttpStatus.OK);
    }

    @PostMapping("/favorite")
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite){
        favoriteService.createFavorite(favorite);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @DeleteMapping("/favorite/{id}")
    public ResponseEntity<Favorite> deleteFavorite(@PathVariable long id){
        favoriteService.deleteFavorite(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}