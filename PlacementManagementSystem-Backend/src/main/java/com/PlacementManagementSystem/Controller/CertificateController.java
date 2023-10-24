package com.PlacementManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlacementManagementSystem.Entity.Certificate;
import com.PlacementManagementSystem.Repository.CertificateRepository;

@Controller
public class CertificateController {

	@Autowired
	private CertificateRepository certificateRepo;

	
	@RequestMapping("/deleteCertificate")
	public String deleteCertificate(@RequestParam("id") Integer id, ModelMap ModelMap) {
		certificateRepo.deleteById(id);
		List<Certificate> findAllCertificate = certificateRepo.findAll();
		ModelMap.addAttribute("findAllCertificate", findAllCertificate);
		return "certificateDisplay.jsp";
	}
	
	
	@RequestMapping("/updateCertificate")
	public String updateCertificate(@ModelAttribute("certificate") Certificate certificate, ModelMap ModelMap) {
		Optional<Certificate> findById2 = certificateRepo.findById(certificate.getId());
		Certificate certificate2 = findById2.get();
		certificate2.setCollege(certificate.getCollege());
		certificate2.setYear(certificate.getYear());
		certificateRepo.save(certificate2);
		List<Certificate> findAllCertificate = certificateRepo.findAll();
		ModelMap.addAttribute("findAllCertificate", findAllCertificate);
		return "certificateDisplay.jsp";
	}
	
	
	@RequestMapping("/editCertificate")
	public String editCertificate(@RequestParam("id") Integer id, ModelMap ModelMap) {
		Optional<Certificate> findById = certificateRepo.findById(id);
		Certificate certificate = findById.get();
		ModelMap.addAttribute("certificate", certificate);
		return "certificateIndex.jsp";
	}

	@RequestMapping("/showAllCertificates")
	public String showAllCertificates(ModelMap ModelMap) {
		List<Certificate> findAllCertificate = certificateRepo.findAll();
		ModelMap.addAttribute("findAllCertificate", findAllCertificate);
		return "certificateDisplay.jsp";
	}

	@RequestMapping("/insertCertificate")
	public String insertCertificate(@ModelAttribute("certificate") Certificate certificate, ModelMap ModelMap) {
		certificateRepo.save(certificate);
		List<Certificate> findAllCertificate = certificateRepo.findAll();
		ModelMap.addAttribute("findAllCertificate", findAllCertificate);
		return "certificateDisplay.jsp";
	}

}
