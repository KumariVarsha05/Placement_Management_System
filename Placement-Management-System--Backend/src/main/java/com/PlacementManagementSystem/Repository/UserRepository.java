package com.PlacementManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PlacementManagementSystem.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByname(String name);

}
