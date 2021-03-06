package com.sit.cloudnative.ProfileService.Favorite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    public List<Favorite> getByStudentId(Long studentId);
}
