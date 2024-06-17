/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.IConstant;
import java.util.Scanner;
import utils.Validate;

/**
 *
 * @author Admin
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        String hex;
        long dec;
        int i;
        
        System.out.print("Enter hexadecimal number: ");
        hex = SCANNER.nextLine();
        dec = 0;
        for (i = 0; i < hex.length(); i++) {
            int digit = hexValue(hex.charAt(i));
            if (digit == -1) {
                System.err.println("Error: Input is not a hexadecimal number.");
                return;
            }
            dec = 16 * dec + digit;
        }
        System.out.println("Base-10 value: " + dec);
    }
    
    /**
     * Returns the hexadecimal value of a given character, or -1 if it is not
     * a valid hexadecimal digit.
     * 
     * @param ch the character that is to be converted into a hexadecimal digit
     * @return the hexadecimal value of character, or -1 if character is not 
     * a legal hexadecimal digit
     */
    static int hexValue(char ch) {
        switch (ch) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'a':
            case 'A':
                return 10;
            case 'b':
            case 'B':
                return 11;
            case 'c':
            case 'C':
                return 12;
            case 'd':
            case 'D':
                return 13;
            case 'e':
            case 'E':
                return 14;
            case 'f':
            case 'F':
                return 15;
            default:
                return -1;
        }
    }

}
    
