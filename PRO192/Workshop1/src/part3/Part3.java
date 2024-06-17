/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Part3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] list = new String[10];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the student name: ");
            list[i] = sc.nextLine();

            
            list[i] = StandardizeName(list[i]);


        }

        for (int i = 0; i < n; i++) {
            System.out.println("The student name: " + list[i]);
        }
    }
    public static String StandardizeName(String s) {
        s = s.replaceAll("[^a-zA-Z ]", " ");
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase());
                result.append(word.substring(1).toLowerCase());
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}
