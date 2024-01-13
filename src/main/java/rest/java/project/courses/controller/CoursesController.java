package rest.java.project.courses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rest.java.project.courses.entity.Courses;
import rest.java.project.courses.exception.CourseNotFoundException;
import rest.java.project.courses.repo.CoursesRepository;

@RestController
public class CoursesController {
	private final CoursesRepository repository;
	public CoursesController(CoursesRepository cr) {
		this.repository = cr;
	}
	
	// Get all courses
	@GetMapping("/courses")
	List<Courses> getAllCourses(){
		return (List<Courses>) repository.findAll();
	}
	
	// Add new course to database
	@PostMapping("/courses")
	Courses addNewCourse(@RequestBody Courses course) {
		return repository.save(course);
	}
	
	// Get one course by ID, if the course does not exist return 404
	@GetMapping("/courses/{id}")
	Courses getOneCourse(@PathVariable int id) {
		return repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
	}
	
	@DeleteMapping("/courses/{id}")
	void deleteCourse(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	
}