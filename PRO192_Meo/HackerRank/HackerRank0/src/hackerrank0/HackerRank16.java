/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank0;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class HackerRank16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y, z, t;
        x = sc.nextLong();
        y = sc.nextLong();
        z = sc.nextLong();
        t = sc.nextLong();
        System.out.printf("%d  %d  %d  %d\n\n", x, y, z, t);
        System.out.printf("%d--%d--%d--%d\n\n", y, z, x, t);
        System.out.printf("%d,%d,%d,%d\n\n", 2*x, 3*y, 4*z, 5*t);
        System.out.println("KET THUC !!");
    }
}
