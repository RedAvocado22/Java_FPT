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
public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Input validated information for rectangle.
     */
    @Override
    public void input() {
        this.length = Validate.getDouble(
                "Please input side length of Rectangle: ", 
                "It must be a positive number!", 
                "It must be a number!",
                0, Double.MAX_VALUE
        );
        
        this.width = Validate.getDouble(
                "Please input side width of Rectangle: ", 
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
        return width * length;
    }

    /**
     * Calculate the perimeter.
     *
     * @return a double present for perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * Print the information of rectangle and it's perimeter and area.
     */
    @Override
    public void printResult() {
        System.out.println("----- Rectangle -----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
