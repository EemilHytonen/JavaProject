package rest.java.project.courses.exception;

public class CourseNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CourseNotFoundException(int id) {
		super("The id does not match any course: " + id);
	}
}
