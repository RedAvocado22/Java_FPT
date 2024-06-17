/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellojava;

import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class HelloJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        inputArrays(n, a);
        int min = a[0], max = a[0], tong = a[0];
        for (int i = 1; i < n; i++) {
            if(a[i] < min) min = a[i];
            if(a[i] > max) max = a[i];
            tong += a[i];
        }
        System.out.println(min);
        System.out.println(max);
        System.out.println((double)tong/n);
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static void inputArrays(int n, int a[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
    }
}
