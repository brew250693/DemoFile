package controller;

import model.Student;
import storage.FileManager;

import java.io.IOException;
import java.util.List;

public class StudentManager {
    private String name;
    private List<Student> studentsList;
    public void addNewStudent(Student student) throws IOException {
        studentsList.add(student);
        FileManager.writeFile(studentsList);
    }
    public boolean editStudent(int index,Student student) throws IOException {
        studentsList.set(index,student);
        FileManager.writeFile(studentsList);
        return true;
    }
    public boolean deleteStudent(int index) throws IOException{
        Student a = null;
        for (Student s :studentsList
             ) {
            if(s.getId() == index){
                a = s;
                break;
            }
        }
        if(a == null)
            return false;
        else {
            studentsList.remove(a);
            FileManager.writeFile(studentsList);
        }
        return true;
    }


    public void showAllStudent(){
        for (Student s:studentsList
             ) {
            System.out.println(s);
        }
    }

    public StudentManager() {
    }

    public StudentManager(String name, List<Student> studentsList) {
        this.name = name;
        this.studentsList = studentsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }



}

