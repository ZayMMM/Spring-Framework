package spring.rest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> studentLists;

	@PostConstruct
	public void loadData() {

		studentLists = new ArrayList<Student>();
		studentLists.add(new Student("John", "Doe"));
		studentLists.add(new Student("Mary", "Blue"));
		studentLists.add(new Student("Fary", "Light"));

	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentLists;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if ((studentId >= studentLists.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found : " + studentId);
		}

		return studentLists.get(studentId);
	}

}
