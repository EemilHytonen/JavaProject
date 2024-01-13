package rest.java.project.students.repo;

import org.springframework.data.repository.CrudRepository;

import rest.java.project.students.Students;

public interface StudentsRepo extends CrudRepository<Students, Integer> {

}