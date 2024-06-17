/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuong.util;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
    
//LIBRARY - chứa các hàm/biến(data) dùng chung cho nhiều công việc khác nhau của các dự án khác nhau
public class MyToys {
    public static final double PI = 3.145;
    public static final int MAXELEMENT = 99999999;
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int getPositiveInt() {
        int n;
        do {
            try {
                System.out.print("Enter integer: ");
                n = Integer.parseInt(sc.nextLine());
                if (n < 0) {
                    throw new Exception("Error - Must be > 0");
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Error - Must be a number");
            } catch (Exception e) {
                System.out.println("Error - Must be > 0");
            }
        } while (true);
    }
    
    public static int getInteger(String inputMsg) {
        int n;
        do {
            try {
                System.out.print("Enter " + inputMsg + ": ");
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Error - Must be a number");
            }
        } while (true);
    }
}
