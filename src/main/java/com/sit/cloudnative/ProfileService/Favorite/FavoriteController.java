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
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable long studnetId){
        Favorite stuFavorite = favoriteService.getFavoriteByStudentId(studnetId);
        return new ResponseEntity<Favorite>(stuFavorite,HttpStatus.OK);
    }

}