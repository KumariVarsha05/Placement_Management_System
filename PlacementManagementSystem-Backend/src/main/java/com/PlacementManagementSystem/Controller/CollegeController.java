package com.PlacementManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlacementManagementSystem.Entity.College;
import com.PlacementManagementSystem.Repository.CollegeRepository;

@Controller
public class CollegeController {

	@Autowired
	private CollegeRepository collegeRepo;

	@RequestMapping("/deleteCollege")
	public String deleteCollege(@RequestParam("id") Integer id, ModelMap ModelMap) {
		collegeRepo.deleteById(id);
		List<College> findAllCollege = collegeRepo.findAll();
		ModelMap.addAttribute("findAllCollege", findAllCollege);
		return "collegeDisplay.jsp";
	}

	@RequestMapping("/updateCollege")
	public String updateCollege(@ModelAttribute("college") College college, ModelMap ModelMap) {
		Optional<College> findById2 = collegeRepo.findById(college.getId());
		College college2 = findById2.get();
		college2.setCollegedmin(college.getCollegedmin());
		college2.setCollegename(college.getCollegename());
		college2.setLocation(college.getLocation());
		collegeRepo.save(college2);
		List<College> findAllCollege = collegeRepo.findAll();
		ModelMap.addAttribute("findAllCollege", findAllCollege);
		return "collegeDisplay.jsp";
	}

	@RequestMapping("/editCollege")
	public String editCollege(@RequestParam("id") Integer id, ModelMap ModelMap) {
		Optional<College> findById = collegeRepo.findById(id);
		College college = findById.get();
		ModelMap.addAttribute("college", college);
		return "collegeIndex.jsp";
	}

	@RequestMapping("/showAllCollege")
	public String showAllCollege(ModelMap ModelMap) {
		List<College> findAllCollege = collegeRepo.findAll();
		ModelMap.addAttribute("findAllCollege", findAllCollege);
		return "collegeDisplay.jsp";
	}

	@RequestMapping("/insertCollege")
	public String insertCollege(@ModelAttribute("college") College college, ModelMap ModelMap) {
		collegeRepo.save(college);
		List<College> findAllCollege = collegeRepo.findAll();
		ModelMap.addAttribute("findAllCollege", findAllCollege);
		return "collegeDisplay.jsp";
	}

}
