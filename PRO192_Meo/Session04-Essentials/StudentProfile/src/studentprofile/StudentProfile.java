/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprofile;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class StudentProfile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inputProfile();
    }
    
    public static void inputProfile() {
        String name, address;
        int yob;
        Scanner sc = new Scanner(System.in);
                
        System.out.print("Enter name: ");
        name = sc.nextLine().toUpperCase();
        
        System.out.print("Enter yob: ");
        //yob = sc.nextInt();
        
        //xóa bộ nhớ đệm theo cách tà giáo
        //sc.nextLine();
        
        //xóa bộ nhớ theo cách chính thống
        yob = Integer.parseInt(sc.nextLine());
        //nextLine() hốt sạch buffer, loại bỏ enter, còn chuỗi số -> số
        
        System.out.print("Enter address: ");
        address = sc.nextLine().toUpperCase();
        
        outputProfile(name, address, yob);
    }
    
    public static void outputProfile(String name, String address, int yob) {
        System.out.println("\nHere is your profile");
        System.out.println("Name: " + name);
        System.out.println("YOB: " + yob);
        System.out.println("Address: " + address);
    }
}
