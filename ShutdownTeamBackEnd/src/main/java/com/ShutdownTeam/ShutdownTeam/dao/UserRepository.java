package com.ShutdownTeam.ShutdownTeam.dao;

import com.ShutdownTeam.ShutdownTeam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {
   User findByUsername(String username);
}