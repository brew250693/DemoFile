package view;

import controller.StudentManager;
import model.Student;
import storage.FileManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        List<Student> c0221i1 = null;
        try {
            c0221i1 = FileManager.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StudentManager khanh = new StudentManager("Khanhcute",c0221i1);

        while (true){
            Scanner sc3 = new Scanner(System.in);
            System.out.println("Moi ban nhap lua chon: ");
            System.out.println("Bam 1 de them moi");
            System.out.println("Bam 2 de hien thi");
            System.out.println("Bam 3 de sua");
            System.out.println("bam 4 de xoa");
            System.out.println("bam 5 de ket thuc");
            int choose = sc3.nextInt();
            switch (choose){
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Moi ban nhap ID: ");
                    int id = sc.nextInt();
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Moi ban nhap Name: ");
                    String name = sc1.nextLine();
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Moi ban nhap Address: ");
                    String address = sc2.nextLine();
                    Student s = new Student(id,name,address);
                    khanh.addNewStudent(s);
                    break;
                case 2:
                    khanh.showAllStudent();
                    sc3.nextLine();
                    break;
                case 3:
                    Scanner sc6 = new Scanner(System.in);
                    System.out.println("Moi ban nhap ID: ");
                    int id1 = sc6.nextInt();
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("Moi ban nhap Name: ");
                    String name1 = sc4.nextLine();
                    Scanner sc5 = new Scanner(System.in);
                    System.out.println("Moi ban nhap Address: ");
                    String address1 = sc5.nextLine();
                    Student student1 = new Student(id1,name1,address1);
                    khanh.editStudent(id1,student1);
                    break;
                case 4:
                    Scanner sc7 = new Scanner(System.in);
                    System.out.println("Moi ban nhap ID de xoa: ");
                    int id2 = sc7.nextInt();
                    khanh.deleteStudent(id2);
                    khanh.showAllStudent();
                    break;
                case 5:
                    return;
            }
        }
    }
}
