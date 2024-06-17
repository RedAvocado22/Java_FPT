package javaapplication7;

import java.util.Scanner;

public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        System.out.println(n*2);
        System.out.println(n*10);
        System.out.println(n/2);
        System.out.printf("%.3f\n", (double)n/2);
    }
    
}
