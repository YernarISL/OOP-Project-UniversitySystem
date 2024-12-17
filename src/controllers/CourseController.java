package controllers;

import java.util.Vector;

import models.Course;
import models.GeneralDB;
import models.Semester;
import models.Student;

import views.CourseView;

public class CourseController {
	
	public void applyCourseRegistry(Student student, Vector<Course> selectedCourses) {
		student.registerForCourses(selectedCourses);
	}
	
	public void addInitCourses() {
		GeneralDB.courses.add(new Course("CSCI2304", "OOP", 3, Semester.FALL));
		GeneralDB.courses.add(new Course("MATH1412", "Calculus-1", 4, Semester.FALL));
		GeneralDB.courses.add(new Course("STAT1376", "Statistics-1", 3, Semester.SPRING));
		GeneralDB.saveCourses();
	}
	
}
