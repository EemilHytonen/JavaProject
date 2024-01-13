package rest.java.project.students;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Students {
	
    @Id
    private int studentID;
    private String firstname;
    private String lastname;
    private String email;

    public Students() {}

    public Students(int studentID, String firstname, String lastname, String email) {
        this.studentID = studentID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}