/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import data.Student;
import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */

public class StudentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        saveStudents();
    }
    
    public static void inputStudent() {
        String id, name;
        int yob;
        double gpa;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input id: ");
        id = sc.nextLine();
        
        System.out.println("Input name: ");
        name = sc.nextLine();
        
        System.out.println("Input yob: ");
        yob = sc.nextInt();
        
        System.out.println("Input gpa: ");
        gpa = sc.nextDouble();
        
        Student x = new Student(id, name, yob, gpa);
        x.showProfile();
    }
    
    //hard-code
    public static void saveStudents() {
        Student cuong = new Student("HE187382", "Nguyen Minh Cuong", 2004, 9);
        Student an = new Student("HE187222", "Nguyen Minh An", 2004, 1);
        an.showProfile();
        
        //có 2 loại .
        //chấm  trực tiếp vào class tức là bạn đang sờ vào static
        //chấm qua new là chơi non-static - đồ riêng của từng object
        
        //cuong.sayHi();
        System.out.println(cuong.toString());
        
    }
}
