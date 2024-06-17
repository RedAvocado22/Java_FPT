/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank0;

import static hackerrank0.HackerRank18.swap2Integers;
import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class HackerRank19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x;
        int a;
        x = sc.nextDouble();
        a = (int)x;
        System.out.println(a);
        System.out.printf("%.2f\n", x - a);
    }
}
