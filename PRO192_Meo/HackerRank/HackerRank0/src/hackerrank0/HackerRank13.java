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
public class HackerRank13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y, z, t;
        x = sc.nextLong();
        y = sc.nextLong();
        z = sc.nextLong();
        t = sc.nextLong();
        System.out.println(Math.max(x, y));
        System.out.println(Math.min(z, t));
        System.out.println(Math.max(Math.max(x, y), z));
        System.out.println(Math.min(Math.min(Math.min(x, y), z), t));
    }
}
