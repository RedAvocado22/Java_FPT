/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author FPT Shop
 */
public class Dog {
    private String name;
    private int yob;
    private double weight;
    //... more things
    
    //tên phải giống 100% class
    public Dog(String iName, int iYob, double iWeight) {
        name = iName;
        yob = iYob;
        weight = iWeight;
    }
    
    public void Bark() {
        System.out.println("Gold gold gold... My name is: " + name);
        System.out.println("Gold gold gold... My weight is: " + weight);
    }
    
    public void setNewWeight(double newWeight) {
        weight = newWeight;
    }
    
    public int getYob() {
        return yob; 
    }
}
