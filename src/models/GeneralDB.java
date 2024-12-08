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
	private static final long serialVersionUID = 1L;
	private static String filePath = "C:\\Users\\Ernar\\eclipse-workspace\\alphaWSP\\data\\";
	
	public static Vector<Teacher> teachers = new Vector<Teacher>();
	
	public static void saveTeachers() {
		GeneralDB.serialize(teachers, "teachersList.txt");
	}
	
	public static void serialize(Object data, String fileName) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filePath + fileName);
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
			fis = new FileInputStream(filePath = fileName);
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

	public static void setFilePath(String filePath) {
		GeneralDB.filePath = filePath;
	}

}
