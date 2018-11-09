package com.sit.cloudnative.ProfileService.Favorite;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class FavoriteService {

  @Autowired
  FavoriteRepository favoriteRepository;

  public List<Favorite> getFavoriteByStudentId(long studentId){
      return favoriteRepository.getByStudentId(studentId);
  }

  public Favorite createFavorite(Favorite favorite) {
    return favoriteRepository.save(favorite);
  }

  public void deleteFavorite(long id){
    Favorite targetFavorite = favoriteRepository.getOne(id);
    favoriteRepository.delete(targetFavorite);
  }
}