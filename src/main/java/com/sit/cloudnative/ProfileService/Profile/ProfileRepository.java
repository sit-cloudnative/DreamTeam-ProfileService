package com.sit.cloudnative.ProfileService.Profile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    public Profile findByStudentId(long id);
}
