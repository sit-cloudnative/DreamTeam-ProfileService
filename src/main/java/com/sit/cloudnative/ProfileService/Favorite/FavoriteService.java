package com.sit.cloudnative.ProfileService.Favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class FavoriteService {

  @Autowired
  FavoriteRepository favoriteRepo;

  public Favorite getFavoriteByStudentId(long studentId){
      return favoriteRepo.getByStudentId(studentId);
  }

  public Favorite createFavorite(Favorite favorite){
      System.out.print(favorite.toString());
      return favoriteRepo.save(favorite);
  }

  public void deleteFavorite(Favorite favorite){
      favoriteRepo.delete(favorite);
  }
}