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

import com.PlacementManagementSystem.Entity.Certificate;
import com.PlacementManagementSystem.Repository.CertificateRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/CertificateRestController")
public class CertificateRestController {

	@Autowired
	private CertificateRepository certificateRepo;

	@GetMapping
	public Iterable<Certificate> getCertificate() {
		return certificateRepo.findAll();
	}

	@GetMapping("/{id}")
	public Certificate getCertificate(@PathVariable("id") int id) {
		Optional<Certificate> findById = certificateRepo.findById(id);
		Certificate certificate = findById.get();
		return certificate;
	}

	@PostMapping
	public Certificate saveCertificate(@RequestBody Certificate certificate) {
		return certificateRepo.save(certificate);
	}

	@PutMapping
	public Certificate updateCertificate(@RequestBody Certificate certificate) {
		Optional<Certificate> findById2 = certificateRepo.findById(certificate.getId());
		Certificate certificate2 = findById2.get();
		certificate2.setCollege(certificate.getCollege());
		certificate2.setYear(certificate.getYear());
		certificateRepo.save(certificate2);
		return certificateRepo.save(certificate);
	}

	@DeleteMapping("/{id}")
	public void updateCertificate(@PathVariable("id") int id) {
		certificateRepo.deleteById(id);
	}
}
