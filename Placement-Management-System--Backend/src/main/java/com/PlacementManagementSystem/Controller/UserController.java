package com.PlacementManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlacementManagementSystem.Entity.User;
import com.PlacementManagementSystem.Repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") Integer id, ModelMap ModelMap) {
		userRepo.deleteById(id);
		List<User> findAllUser = userRepo.findAll();
		ModelMap.addAttribute("findAllUser", findAllUser);
		return "userDisplay.jsp";
	}
	
	
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user, ModelMap ModelMap) {
		Optional<User> findById2 = userRepo.findById(user.getId());
		User user2 = findById2.get();
		user2.setName(user.getName());
		user2.setPassword(user.getPassword());
		userRepo.save(user2);
		List<User> findAllUser = userRepo.findAll();
		ModelMap.addAttribute("findAllUser", findAllUser);
		return "userDisplay.jsp";
	}
	
	
	@RequestMapping("/editUser")
	public String editAdmin(@RequestParam("id") Integer id, ModelMap ModelMap) {
		Optional<User> findById = userRepo.findById(id);
		User user = findById.get();
		ModelMap.addAttribute("user", user);
		return "userIndex.jsp";
	}

	@RequestMapping("/showAllUsers")
	public String showAllUsers(ModelMap ModelMap) {
		List<User> findAllUser = userRepo.findAll();
		ModelMap.addAttribute("findAllUser", findAllUser);
		return "userDisplay.jsp";
	}

	@RequestMapping("/insertUser")
	public String insertAdmin(@ModelAttribute("user") User user, ModelMap ModelMap) {
		userRepo.save(user);
		List<User> findAllUser = userRepo.findAll();
		ModelMap.addAttribute("findAllUser", findAllUser);
		return "userDisplay.jsp";
	}

	@RequestMapping("/verifyUserlogin")
	public String verifyLogin(@RequestParam("name") String name, @RequestParam("password") String password,
			ModelMap modelmap) {
		User user = userRepo.findByname(name);
		
		if (user != null) {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				return "UserDashboard.html";
			} else {
				modelmap.addAttribute("error", "Entered emailId or Password is incorrect");
				return "UserLogin.html";
			}
		}
		modelmap.addAttribute("error", "Entered emailId or Password is incorrect");
		return "UserLogin.html";
	}
}
