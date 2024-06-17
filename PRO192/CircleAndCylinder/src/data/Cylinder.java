/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;
import util.MyToys;

/**
 *
 * @author FPT Shop
 */
public class Cylinder extends Circle {

    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String colour) {
        super(radius, colour);
        this.height = height;
    }
    
    public void inputCylinder() { 
        super.setRadius(MyToys.getADouble("Enter radius: ", "Try again!"));
        height = MyToys.getADouble("Enter height: ", "Try again!");
        super.setColour(MyToys.getAString("colour"));
    }
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return (super.getArea() * height);
    }
    
    @Override
    public double getArea() {
        return (2 * super.getArea() + 2 * Math.PI * super.getRadius() * height);
    }

    @Override
    public String toString() {
        return String.format("|radius: %-6.2f|height: %-6.2f|colour: %-6s|", super.getRadius(), height,super.getColour());
    }
}
