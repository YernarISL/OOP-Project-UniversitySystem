package controllers;

import models.Course;
import models.GeneralDB;
import models.Semester;

public class CourseController {
	
	
	public void addInitCourses() {
		GeneralDB.courses.put("CSCI2304", new Course("CSCI2304", "OOP", 3, Semester.FALL));
		GeneralDB.courses.put("MATH1412", new Course("MATH1412", "Calculus-1", 4, Semester.FALL));
		GeneralDB.courses.put("STAT1376", new Course("STAT1376", "Statistics-1", 3, Semester.SPRING));
		GeneralDB.saveCourses();
	}
}
