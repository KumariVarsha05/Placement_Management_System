package com.PlacementManagementSystem;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.PlacementManagementSystem.Entity.Admin;
import com.PlacementManagementSystem.Repository.AdminRepository;

import com.PlacementManagementSystem.Entity.User;
import com.PlacementManagementSystem.Repository.UserRepository;

@SpringBootTest
class PlacementManagementSystemApplicationTests {

	//Testing of Admin
	@Autowired
	AdminRepository adminRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void insertAdminRecord() {
		Admin admin = new Admin();
		admin.setName("ankit");
		admin.setPassword("ankit");
		adminRepo.save(admin);
	}

	@Test
	public void updateAdminRecord() {
		Optional<Admin> findById = adminRepo.findById((int) 7L);
		Admin admin = findById.get();
		admin.setName("pk");
		adminRepo.save(admin);
	}

	@Test
	public void deleteAdminRecord() {
		adminRepo.deleteById((int) 7L);
	}

	@Test
	public void fetchAdminRecord() {
		Optional<Admin> findById = adminRepo.findById((int) 1L);
		Admin admin = findById.get();
		System.out.println(admin.getId());
		System.out.println(admin.getName());
		System.out.println(admin.getPassword());
	}

	@Test
	public void fetchAllAdminRecord() {
		Iterable<Admin> allAdmin = adminRepo.findAll();
		System.out.println(allAdmin);
	}

	
	
	//Testing of User
	@Autowired
	UserRepository userRepo;

	@Test
	void insertUserRecord() {
		User user = new User();
		user.setName("ankit");
		user.setPassword("ankit");
		user.setType("Student");
		userRepo.save(user);
	}

	@Test
	public void updateUserRecord() {
		Optional<User> findById = userRepo.findById((int) 8L);
		User user = findById.get();
		user.setName("pk");
		userRepo.save(user);
	}

	@Test
	public void deleteUserRecord() {
		userRepo.deleteById((int) 8L);
	}

	@Test
	public void fetchUserRecord() {
		Optional<User> findById = userRepo.findById((int) 1L);
		User user = findById.get();
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
	}

	@Test
	public void fetchAllUserRecord() {
		Iterable<User> allUser = userRepo.findAll();
		System.out.println(allUser);
	}

}
