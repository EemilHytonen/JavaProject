package rest.java.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import rest.java.project.courses.entity.Courses;
import rest.java.project.courses.repo.CoursesRepository;
import rest.java.project.students.Students;
import rest.java.project.students.repo.StudentsRepo;

@SpringBootTest
class JavaProjectApplicationTests {

    @Autowired
    CoursesRepository rRepository;

    @Autowired
    StudentsRepo sRepository;

    @Test
    void contextLoads() {
    }

    // Course tests

    @Test
    @WithUserDetails(value = "admin@student.com")
    void testCreateCourse() {
        // Create a new course
        Courses c = new Courses(1, "Math", "Jamochello");

        // Save the course to the repository
        rRepository.save(c);

        // Retrieve the course from the repository
        Courses savedCourse = rRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(savedCourse).isNotNull();
        assertThat(savedCourse.getName()).isEqualTo("Math");
    }

    @Test
    @WithUserDetails(value = "user@student.com")
    void testReadCourse() {
        // Retrieve a course from the repository
        Courses c = rRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(c).isNotNull();
        assertThat(c.getName()).isEqualTo("Math");
    }

    @Test
    @WithUserDetails(value = "admin@student.com")
    void testUpdateCourse() {
        // Retrieve a course from the repository
        Courses c = rRepository.findById(1).orElse(null);
        assertThat(c).isNotNull();

        // Update the course's name
        c.setName("Physics");
        rRepository.save(c);

        // Retrieve the updated course from the repository
        Courses updatedCourse = rRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(updatedCourse).isNotNull();
        assertThat(updatedCourse.getName()).isEqualTo("Physics");
    }

    @Test
    @WithUserDetails(value = "admin@student.com")
    void testDeleteCourse() {
        // Create a new course
        Courses c = new Courses(5, "Math", "Jamochello");

        // Save the course to the repository
        rRepository.save(c);

        // Delete the course from the repository
        rRepository.deleteById(5);

        // Attempt to retrieve the deleted course from the repository
        Courses deletedCourse = rRepository.findById(5).orElse(null);

        // Perform assertions
        assertThat(deletedCourse).isNull();
    }

    // Student tests

    @Test
    @WithUserDetails(value = "admin@student.com")
    void testCreateStudent() {
        // Create a new student
        Students s = new Students(1, "Esa", "Example", "test@test.com");

        // Save the student to the repository
        sRepository.save(s);

        // Retrieve the student from the repository
        Students savedStudent = sRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getLastname()).isEqualTo("Example");
    }

    @Test
    @WithUserDetails(value = "admin@student.com")
    void testUpdateStudent() {
        // Retrieve a student from the repository
        Students s = sRepository.findById(1).orElse(null);
        assertThat(s).isNotNull();

        // Update the student's lastname
        s.setLastname("Puumaja");
        sRepository.save(s);

        // Retrieve the updated student from the repository
        Students updatedStudent = sRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(updatedStudent).isNotNull();
        assertThat(updatedStudent.getLastname()).isEqualTo("Puumaja");
    }

    @Test
    @WithUserDetails(value = "user@student.com")
    void testReadStudent() {
        // Retrieve a student from the repository
        Students s = sRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(s).isNotNull();
        assertThat(s.getLastname()).isEqualTo("Puumaja");
    }

    @Test
    @WithUserDetails(value = "admin@student.com")
    void testDeleteStudent() {
        // Create a new student
        Students s = new Students(1, "Esa", "Example", "test@test.com");

        // Save the student to the repository
        sRepository.save(s);

        // Delete the student from the repository
        sRepository.deleteById(1);

        // Attempt to retrieve the deleted student from the repository
        Students deletedStudent = sRepository.findById(1).orElse(null);

        // Perform assertions
        assertThat(deletedStudent).isNull();
    }

}
