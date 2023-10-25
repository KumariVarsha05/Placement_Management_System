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

import com.PlacementManagementSystem.Entity.Student;
import com.PlacementManagementSystem.Repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/StudentRestController")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping
	public Iterable<Student> getStudent() {
		return studentRepo.findAll();
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		Optional<Student> findById = studentRepo.findById(id);
		Student student = findById.get();
		return student;
	}

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@PutMapping
	public Student updateStudent(@RequestBody Student student) {
		Optional<Student> findById2 = studentRepo.findById(student.getId());
		Student student2 = findById2.get();
		student2.setCertificate(student.getCertificate());
		student2.setCollege(student.getCollege());
		student2.setCourse(student.getCourse());
		student2.setHallTicketNo(student.getHallTicketNo());
		student2.setName(student.getName());
		student2.setQualification(student.getQualification());
		student2.setRoll(student.getRoll());
		student2.setYear(student.getYear());
		studentRepo.save(student2);
		return studentRepo.save(student);
	}

	@DeleteMapping("/{id}")
	public void updateStudent(@PathVariable("id") int id) {
		studentRepo.deleteById(id);
	}
}