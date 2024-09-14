/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Input validated information for circle.
     */
    @Override
    public void input() {
        this.radius = Validate.getDouble(
                "Please input radius of Circle: ", 
                "It must be a positive number!", 
                "It must be a number!", 
                0, Double.MAX_VALUE
        );
    }
    
    /**
     * Calculate the area.
     * 
     * @return a double present for area.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculate the perimeter.
     * 
     * @return a double present for perimeter.
     */
    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    /**
     * Print the information of circle and it's perimeter and area.
     */
    @Override
    public void printResult() {
        System.out.println("----- Circle -----");
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

}
