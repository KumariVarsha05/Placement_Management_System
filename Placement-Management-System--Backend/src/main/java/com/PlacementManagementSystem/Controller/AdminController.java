package com.PlacementManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlacementManagementSystem.Entity.Admin;
import com.PlacementManagementSystem.Repository.AdminRepository;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepo;

	
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(@RequestParam("id") Integer id, ModelMap ModelMap) {
		adminRepo.deleteById(id);
		List<Admin> findAllAdmin = adminRepo.findAll();
		ModelMap.addAttribute("findAllAdmin", findAllAdmin);
		return "adminDisplay.jsp";
	}
	
	
	@RequestMapping("/updateAdmin")
	public String updateAdmin(@ModelAttribute("admin") Admin admin, ModelMap ModelMap) {
		Optional<Admin> findById2 = adminRepo.findById(admin.getId());
		Admin admin2 = findById2.get();
		admin2.setName(admin.getName());
		admin2.setPassword(admin.getPassword());
		adminRepo.save(admin2);
		List<Admin> findAllAdmin = adminRepo.findAll();
		ModelMap.addAttribute("findAllAdmin", findAllAdmin);
		return "adminDisplay.jsp";
	}
	
	
	@RequestMapping("/editAdmin")
	public String editAdmin(@RequestParam("id") Integer id, ModelMap ModelMap) {
		Optional<Admin> findById = adminRepo.findById(id);
		Admin admin = findById.get();
		ModelMap.addAttribute("admin", admin);
		return "adminIndex.jsp";
	}

	@RequestMapping("/showAllAdmin")
	public String showAllAdmin(ModelMap ModelMap) {
		List<Admin> findAllAdmin = adminRepo.findAll();
		ModelMap.addAttribute("findAllAdmin", findAllAdmin);
		return "adminDisplay.jsp";
	}

	@RequestMapping("/insertAdmin")
	public String insertAdmin(@ModelAttribute("admin") Admin admin, ModelMap ModelMap) {
		adminRepo.save(admin);
		List<Admin> findAllAdmin = adminRepo.findAll();
		ModelMap.addAttribute("findAllAdmin", findAllAdmin);
		return "adminDisplay.jsp";
	}

	@RequestMapping("/verifyadminlogin")
	public String verifyLogin(@RequestParam("name") String name, @RequestParam("password") String password,
			ModelMap modelmap) {
		Admin admin = adminRepo.findByname(name);
		if (admin != null) {
			if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
				return "AdminDashboard.html";
			} else {
				modelmap.addAttribute("error", "Entered emailId or Password is incorrect");
				return "AdminLogin.html";
			}
		}
		modelmap.addAttribute("error", "Entered emailId or Password is incorrect");
		return "AdminLogin.html";
	}
}
