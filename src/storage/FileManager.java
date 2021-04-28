package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Student> readFile() throws IOException, ClassNotFoundException {
        File file = new File("List1.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length()>0){
            FileInputStream fileInputStream = new FileInputStream("List1.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            List<Student> list = (List<Student>) obj;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public static void writeFile(List<Student> students) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("List1.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();
    }
    public static void deleteFile()throws IOException{
        File fileOutputStream = new File("List1.dat");
       fileOutputStream.delete();
       fileOutputStream.exists();
    }
}
