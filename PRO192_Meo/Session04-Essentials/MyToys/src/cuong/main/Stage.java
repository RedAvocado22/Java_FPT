/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuong.main;

import cuong.util.MyToys;

/**
 *
 * @author FPT Shop
 */
public class Stage {
    
    public static void main(String[] args) {
        System.out.println("PI: " + MyToys.PI);
        int n = MyToys.getInteger("Choice");
        System.out.println(n);
    }
}
