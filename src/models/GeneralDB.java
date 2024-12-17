package models;

import java.util.Vector;

public class GeneralDB {

	private static String filePath = "C:\\Users\\Ernar\\eclipse-workspace\\alphaWSP\\data\\";
	
	public static Vector<Teacher> teachers = new Vector<Teacher>();
	public static Vector<Student> students = new Vector<Student>();
	public static Vector<Manager> managers = new Vector<Manager>();
	public static Vector<Course> courses = new Vector<Course>();

	
	{
		students = getStudents();
	}
	
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
	
	public static Vector<Manager> getManagers() {
		Object obj = ReadAndWrite.deserialize(filePath + "managersList.txt");
		if (obj instanceof Vector) {
			return (Vector<Manager>) obj;
		}
		return null;
	}
	
	public static Vector<Course> getCourses() {
		Object obj = ReadAndWrite.deserialize(filePath + "coursesList.txt");
		if (obj instanceof Vector) {
			return (Vector<Course>) obj;
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
	
	public static void saveManagers() {
		ReadAndWrite.serialize(managers, filePath + "managersList.txt");
	}
	
	public static String getPath() {
		return filePath;
	}
}
