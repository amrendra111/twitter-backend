package com.twitter.twitter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.twitter.UserEntities.Entity.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}
