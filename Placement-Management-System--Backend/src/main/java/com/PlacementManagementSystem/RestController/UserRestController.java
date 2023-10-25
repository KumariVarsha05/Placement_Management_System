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

import com.PlacementManagementSystem.Entity.User;
import com.PlacementManagementSystem.Repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/UserRestController")
public class UserRestController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping
	public Iterable<User> getUser() {
		return userRepo.findAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id) {
		Optional<User> findById = userRepo.findById(id);
		User user = findById.get();
		return user;
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		Optional<User> findById2 = userRepo.findById(user.getId());
		User user2 = findById2.get();
		user2.setName(user.getName());
		user2.setPassword(user.getPassword());
		userRepo.save(user2);
		return userRepo.save(user);
	}

	@DeleteMapping("/{id}")
	public void updateUser(@PathVariable("id") int id) {
		userRepo.deleteById(id);
	}
}
