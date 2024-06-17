/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class WorkShop1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        solve();
        printPrimeList();
    }
    
    public static void solve() {
        double a, b;
        System.out.println("Enter a and b for ax + b = 0");
        a = getADouble();
        b = getADouble();
        if( a == 0 ) {
            if( b == 0 ) System.out.println("True with every x.");
            else System.out.println("No result for x.");
        }
        else System.out.println("Result: x = " + (-b / a));
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i*i <= n; i++) 
            if(n % i == 0) return false;
        return true;
    }
    
    public static void print1000FirstPrimes() {
        int count = 1;
        for (int i = 2; count <= 1000 ; i++) 
            if(isPrime(i)) {
                System.out.print( + i + " ");
                count++;
            }
        System.out.println("");
    }
    
    public static void printPrimeList() {
        for (int i = 2; i <= 1000; i++) {
            if(isPrime(i)) System.out.print( + i + " "); 
        }
        System.out.println("");
    }
    
    public static double getADouble() {
        double n;
        
        Scanner myKeyboard = new Scanner(System.in);
        
        System.out.print("Input a positive integer: ");
        n = myKeyboard.nextDouble();
        
        return n;
    }
}
