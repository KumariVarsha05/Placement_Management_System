package com.PlacementManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PlacementManagementSystem.Entity.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Integer> {

}
