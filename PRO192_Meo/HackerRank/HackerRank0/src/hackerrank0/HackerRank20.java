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
public class HackerRank20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();
        String str = String.format("%06d", a);
        System.out.println(str);
        int b = a, dem = 0;
        while(b > 0) {
            b /= 10;
            dem++;
        }
        for (int i = dem; i < 6; i++) {
            System.out.printf("#");
        }
        System.out.println(a);
    }
}
