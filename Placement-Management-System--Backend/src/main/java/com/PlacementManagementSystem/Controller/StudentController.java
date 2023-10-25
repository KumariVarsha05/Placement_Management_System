package com.PlacementManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlacementManagementSystem.Entity.Student;
import com.PlacementManagementSystem.Repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;

	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("id") Integer id, ModelMap ModelMap) {
		studentRepo.deleteById(id);
		List<Student> findAllStudent = studentRepo.findAll();
		ModelMap.addAttribute("findAllStudent", findAllStudent);
		return "studentDisplay.jsp";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student") Student student, ModelMap ModelMap) {
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
		List<Student> findAllStudent = studentRepo.findAll();
		ModelMap.addAttribute("findAllStudent", findAllStudent);
		return "studentDisplay.jsp";
	}

	@RequestMapping("/editStudent")
	public String editStudent(@RequestParam("id") Integer id, ModelMap ModelMap) {
		Optional<Student> findById = studentRepo.findById(id);
		Student student = findById.get();
		ModelMap.addAttribute("student", student);
		return "studentIndex.jsp";
	}

	@RequestMapping("/showAllStudent")
	public String showAllAdmin(ModelMap ModelMap) {
		List<Student> findAllStudent = studentRepo.findAll();
		ModelMap.addAttribute("findAllStudent", findAllStudent);
		return "studentDisplay.jsp";
	}

	@RequestMapping("/insertStudent")
	public String insertStudent(@ModelAttribute("student") Student student, ModelMap ModelMap) {
		studentRepo.save(student);
		List<Student> findAllStudent = studentRepo.findAll();
		ModelMap.addAttribute("findAllStudent", findAllStudent);
		return "studentDisplay.jsp";
	}

}
