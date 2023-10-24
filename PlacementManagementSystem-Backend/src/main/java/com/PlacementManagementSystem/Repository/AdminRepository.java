package com.PlacementManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PlacementManagementSystem.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByname(String name);

}
