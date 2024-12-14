package models;

import java.util.Vector;
import java.util.HashMap;


public class GeneralDB {

	private static String filePath = "C:\\Users\\Ernar\\eclipse-workspace\\alphaWSP\\data\\";
	
	public static Vector<Teacher> teachers = new Vector<Teacher>();
	public static Vector<Student> students = new Vector<Student>();
	public static Vector<Manager> managers;
	public static HashMap<String, Course> courses = new HashMap<String, Course>();
	
	public static Vector<Teacher> getTeachers() {
		Object obj = ReadAndWrite.deserialize(filePath + "teachersList.txt");
		
		if (obj instanceof Vector) {
			return (Vector<Teacher>) obj;
		
		}
		return null;
	}
	
	public static Vector<Student> getStudents() {
		Object obj = ReadAndWrite.deserialize(filePath + "studentsList.txt");
		if (obj instanceof Vector) {
			return (Vector<Student>) obj;
		
		}
		return null;
	}
	
	public static HashMap<String, Course> getCourses() {
		Object obj = ReadAndWrite.deserialize(filePath + "coursesList.txt");
		
		if (obj instanceof HashMap) {
			return (HashMap<String, Course>) obj;
		}
		return null;
	}
	
	public static void saveTeachers() {
		ReadAndWrite.serialize(teachers, filePath + "teachersList.txt");
	}
	
	public static void saveStudents() {
		ReadAndWrite.serialize(students, filePath + "studentsList.txt");
	}
	
	public static void saveCourses() {
		ReadAndWrite.serialize(courses, filePath + "coursesList.txt");
	}
}
