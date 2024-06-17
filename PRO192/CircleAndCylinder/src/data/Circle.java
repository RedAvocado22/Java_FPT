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
public class Circle {
    private double radius = 1.0;
    private String colour = "red";

    public Circle() {
    }
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public Circle(double radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius() {
        return radius;
    }

    public String getColour() {
        return colour;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public double getArea() {
        return (radius * radius * Math.PI);
    }

    @Override
    public String toString() {
        return String.format("|radius: %.2f|colour: %-10s|", radius, colour);
    }
}
