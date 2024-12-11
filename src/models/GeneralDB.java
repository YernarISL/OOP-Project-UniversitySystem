package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class GeneralDB implements Serializable {

	private static String filePath = "C:\\Users\\Ernar\\eclipse-workspace\\alphaWSP\\data\\";
	
	public static GeneralDB db = new GeneralDB();
	
	public static Vector<Teacher> teachers;
	public static Vector<Student> students;
	public static Vector<Manager> managers;
	
	{
		this.teachers = (Vector<Teacher>) deserialize("teachersList.txt");
	}
	
	public static void saveTeachers() {
		GeneralDB.serialize(teachers, "teachersList.txt");
	}
	
	public static void saveStudents() {
		GeneralDB.serialize(students, "studentsList.txt");
	}
	
	public static void serialize(Object data, String fileName) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(getFilePath() + fileName, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object deserialize(String fileName) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(getFilePath() + fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object result = ois.readObject();
			ois.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getFilePath() {
		return filePath;
	}
	
	public static GeneralDB getDB() {
		return db;
	}

}
