package com.PlacementManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PlacementManagementSystem.Entity.College;

public interface CollegeRepository extends JpaRepository<College, Integer> {

}
