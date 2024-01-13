package rest.java.project.courses.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")

public class Courses {
	@Id
	private int courseID;
	private String name;
	@Column(name="teachername")
	private String teacherName;
	
	public Courses() {}
	
	public Courses(int inputCourseID, String inputName, String inputTeacherName) {
		this.courseID = inputCourseID;
		this.name = inputName;
		this.teacherName = inputTeacherName;
	}
	
	public int getCourseID() {
		return courseID;
	}
	
	
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}