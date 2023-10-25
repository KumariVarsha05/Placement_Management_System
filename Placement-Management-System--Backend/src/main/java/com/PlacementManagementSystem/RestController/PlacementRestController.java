package com.PlacementManagementSystem.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PlacementManagementSystem.Entity.Placement;
import com.PlacementManagementSystem.Repository.PlacementRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/PlacementRestController")
public class PlacementRestController {

	@Autowired
	private PlacementRepository placementRepo;

	@GetMapping
	public Iterable<Placement> getPlacement() {
		return placementRepo.findAll();
	}

	@GetMapping("/{id}")
	public Placement getPlacement(@PathVariable("id") int id) {
		Optional<Placement> findById = placementRepo.findById(id);
		Placement placement = findById.get();
		return placement;
	}

	@PostMapping
	public Placement savePlacement(@RequestBody Placement placement) {
		return placementRepo.save(placement);
	}

	@PutMapping
	public Placement updatePlacement(@RequestBody Placement placement) {
		Optional<Placement> findById2 = placementRepo.findById(placement.getId());
		Placement placement2 = findById2.get();
		placement2.setCollege(placement.getCollege());
		placement2.setDate(placement.getDate());
		placement2.setName(placement.getName());
		placement2.setQualification(placement.getQualification());
		placement2.setYear(placement.getYear());
		placementRepo.save(placement2);
		return placementRepo.save(placement);
	}

	@DeleteMapping("/{id}")
	public void updatePlacement(@PathVariable("id") int id) {
		placementRepo.deleteById(id);
	}
}
