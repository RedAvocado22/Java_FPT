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
public class HackerRank18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y;
        x = sc.nextLong();
        y = sc.nextLong();
        swap2Integers(x, y);
    }
    
    public static void swap2Integers(long a, long b) {
        long temp = a; 
        a = b;
        b = temp;
        System.out.println(128*a + 97*b + 1000);
    }
}
