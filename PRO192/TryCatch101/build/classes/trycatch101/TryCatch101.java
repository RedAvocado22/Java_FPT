/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatch101;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class TryCatch101 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = getRightInt();
        System.out.println("Output: " + n);

        String s;
        boolean check;
        do {            
            s = sc.nextLine();
            check = CheckingName(s);
            if(check) System.out.println("OK");
        } while (!check);
        
        TriangleVip();
    }

    public static int getRightInt() {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
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
        }
        return n;
    }

    public static boolean CheckingName(String s) {
        if (!Character.isUpperCase(s.charAt(0))) {
            System.out.println("Wrong - first letter");
            return false;
        } else if (!s.matches("W")) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isAlphabetic(s.charAt(i))) {
                    System.out.printf("Wrong - special letter [%d]\n", i);
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean CheckIfExist(int a, int b, int c) {
        return ((a + b) > c) && ((a + c) > b) && ((b + c) > a);
    }

    public static void TriangleVip() {
        int a, b, c;
        a = getRightInt();
        b = getRightInt();
        c = getRightInt();
        double p = (double) (a + b + c);
        double acr = (double) 1 / 4 * Math.sqrt((a + b + c) * (a + b - c) * (b + c - a) * (c + a - b));
        if (CheckIfExist(a, b, c)) {
            System.out.printf("Perimeter: %.2f\n", p);
            System.out.printf("Area: %.2f\n", acr);
        } else {
            System.out.printf("(%d, %d, %d) are not 3 edges of a triangle.\n", a, b, c);
            TriangleVip();
        }
    }
}
