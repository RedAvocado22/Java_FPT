/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import util.Validation;

/**
 *
 * @author Admin
 */
public class JavaApplication7 {

    public static void main(String[] args) {
        int[] c = new int[4];
        int[] m = new int[4];

        for (int i = 1; i <= 3; i++) {
            Validation.getAnInteger("Max milk of " + i, "Try again", "Out of range.", Integer.MIN_VALUE, Integer.MAX_VALUE);
            Validation.getAnInteger("Milk in " + i, "Try again", "Out of range.", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        for(int i = 1; i <= 3; i++) {
            int k1 =
        }
    }

}
