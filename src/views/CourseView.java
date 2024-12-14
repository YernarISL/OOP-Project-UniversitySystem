package views;

import java.util.HashMap;

import models.Course;

public class CourseView {
	public void registryMenu(HashMap<String, Course> courses) {
		System.out.println("Course Registry: ");
		System.out.println("===========================================================");
		System.out.println("#" + "    " + "Course ID" + "        "  + "Course Name");
		System.out.println("-----------------------------------------------------------");
		int option = 1;
		for (Course course : courses.values()) {
			System.out.println(option + "." + "   " + course.getCourseCode() + "         " + course.getCourseName());
			option += 1;
		}
	}
	
	
}
