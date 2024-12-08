package models;

import java.util.Date;
import java.util.Vector;

public class Lesson {
	private Date time;
	private Teacher teacher;
	private Vector<Student> students;
	private Course course;
	
	public Lesson(Date time, Teacher teacher, Vector<Student> students, Course course) {
		this.time = time;
		this.teacher = teacher;
		this.students = students;
		this.course = course;
	}
	
}
