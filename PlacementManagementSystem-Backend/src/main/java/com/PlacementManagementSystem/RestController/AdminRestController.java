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

import com.PlacementManagementSystem.Entity.Admin;
import com.PlacementManagementSystem.Repository.AdminRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/AdminRestController")
public class AdminRestController {

	@Autowired
	private AdminRepository adminRepo;

	@GetMapping
	public Iterable<Admin> getAdmin() {
		return adminRepo.findAll();
	}

	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable("id") int id) {
		Optional<Admin> findById = adminRepo.findById(id);
		Admin admin = findById.get();
		return admin;
	}

	@PostMapping
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminRepo.save(admin);
	}

	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin) {
		Optional<Admin> findById2 = adminRepo.findById(admin.getId());
		Admin admin2 = findById2.get();
		admin2.setName(admin.getName());
		admin2.setPassword(admin.getPassword());
		adminRepo.save(admin2);
		return adminRepo.save(admin);
	}

	@DeleteMapping("/{id}")
	public void updateAdmin(@PathVariable("id") int id) {
		adminRepo.deleteById(id);
	}
}
