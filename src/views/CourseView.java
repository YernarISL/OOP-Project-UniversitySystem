package views;

import java.util.Vector;

import models.Course;

public class CourseView {
	public void registryPanel(Vector<Course> courses) {
		System.out.println("Course Registry: ");
		System.out.println("===========================================================");
		System.out.println("#" + "    " + "Course ID" + "        "  + "Course Name");
		System.out.println("-----------------------------------------------------------");
		
		int option = 1;
		for (Course course : courses) {
			System.out.println(option + "." + "   " + course.getCourseCode() + "         " + course.getCourseName());
			option += 1;
		}
		
		System.out.println("===========================================================");
		
		if (courses.size() > 1) {
			System.out.println("There are courses from 1 to " + courses.size());
		} else {
			System.out.println("There is one course");
		
		}
		System.out.println("Enter your choice: ");
	}
	
	
}
