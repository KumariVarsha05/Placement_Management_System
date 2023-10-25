package com.PlacementManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlacementManagementSystem.Entity.Placement;
import com.PlacementManagementSystem.Repository.PlacementRepository;

@Controller
public class PlacementController {

	@Autowired
	private PlacementRepository placementRepo;

	@RequestMapping("/deletePlacement")
	public String deletePlacement(@RequestParam("id") Integer id, ModelMap ModelMap) {
		placementRepo.deleteById(id);
		List<Placement> findAllPlacement = placementRepo.findAll();
		ModelMap.addAttribute("findAllPlacement", findAllPlacement);
		return "placementDisplay.jsp";
	}

	@RequestMapping("/updatePlacement")
	public String updatePlacement(@ModelAttribute("placement") Placement placement, ModelMap ModelMap) {
		Optional<Placement> findById2 = placementRepo.findById(placement.getId());
		Placement placement2 = findById2.get();
		placement2.setCollege(placement.getCollege());
		placement2.setDate(placement.getDate());
		placement2.setName(placement.getName());
		placement2.setQualification(placement.getQualification());
		placement2.setYear(placement.getYear());
		placementRepo.save(placement2);
		List<Placement> findAllPlacement = placementRepo.findAll();
		ModelMap.addAttribute("findAllPlacement", findAllPlacement);
		return "placementDisplay.jsp";
	}

	@RequestMapping("/editPlacement")
	public String editPlacement(@RequestParam("id") Integer id, ModelMap ModelMap) {
		Optional<Placement> findById = placementRepo.findById(id);
		Placement placement = findById.get();
		ModelMap.addAttribute("placement", placement);
		return "placementIndex.jsp";
	}

	@RequestMapping("/showAllPlacement")
	public String showAllPlacement(ModelMap ModelMap) {
		List<Placement> findAllPlacement = placementRepo.findAll();
		ModelMap.addAttribute("findAllPlacement", findAllPlacement);
		return "placementDisplay.jsp";
	}

	@RequestMapping("/insertPlacement")
	public String insertPlacement(@ModelAttribute("placement") Placement placement, ModelMap ModelMap) {
		placementRepo.save(placement);
		List<Placement> findAllPlacement = placementRepo.findAll();
		ModelMap.addAttribute("findAllPlacement", findAllPlacement);
		return "placementDisplay.jsp";
	}

}
