package rest.java.project.students.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import rest.java.project.students.Students;
import rest.java.project.students.repo.StudentsRepo;

@RestController
public class StudentsController{
	private final StudentsRepo repository;	
	public StudentsController(StudentsRepo sr) {
		this.repository = sr;
	}
	
	// Get all students
	@GetMapping("/students")
	List<Students> getAllStudents() {
		return (List<Students>) repository.findAll();
	}
	
	// Add new student to database
	@PostMapping("/students")
	Students addNewStudent(@RequestBody Students student) {
		return repository.save(student);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
	    Students student = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	    repository.delete(student);
	    return ResponseEntity.noContent().build();
	}
}