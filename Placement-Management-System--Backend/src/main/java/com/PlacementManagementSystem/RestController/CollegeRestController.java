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

import com.PlacementManagementSystem.Entity.College;
import com.PlacementManagementSystem.Repository.CollegeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/CollegeRestController")
public class CollegeRestController {

	@Autowired
	private CollegeRepository collegeRepo;

	@GetMapping
	public Iterable<College> getCollege() {
		return collegeRepo.findAll();
	}

	@GetMapping("/{id}")
	public College getCollege(@PathVariable("id") int id) {
		Optional<College> findById = collegeRepo.findById(id);
		College college = findById.get();
		return college;
	}

	@PostMapping
	public College saveCollege(@RequestBody College college) {
		return collegeRepo.save(college);
	}

	@PutMapping
	public College updateCollege(@RequestBody College college) {
		Optional<College> findById2 = collegeRepo.findById(college.getId());
		College college2 = findById2.get();
		college2.setCollegedmin(college.getCollegedmin());
		college2.setCollegename(college.getCollegename());
		college2.setLocation(college.getLocation());
		collegeRepo.save(college2);
		return collegeRepo.save(college);
	}

	@DeleteMapping("/{id}")
	public void updateCollege(@PathVariable("id") int id) {
		collegeRepo.deleteById(id);
	}
}
