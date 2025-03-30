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
public class Triangle extends Shape {

    private double sideA, sideB, sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    /**
     * Input validated information for triangle.
     */
    @Override
    public void input() {
        boolean check;
        do {
            double a = Validate.getDouble(
                    "Please input side A of Triangle: ",
                    "It must be a positive number!",
                    "It must be a number!",
                    0, Double.MAX_VALUE
            );

            double b = Validate.getDouble(
                    "Please input side A of Triangle: ",
                    "It must be a positive number!",
                    "It must be a number!",
                    0, Double.MAX_VALUE
            );

            double c = Validate.getDouble(
                    "Please input side A of Triangle: ",
                    "It must be a positive number!",
                    "It must be a number!",
                    0, Double.MAX_VALUE
            );

            if (a + b > c && b + c > a && a + c > b) {
                this.sideA = a;
                this.sideB = b;
                this.sideC = c;
                check = false;
            } else {
                System.out.println("Try again! The triangle not exist!");
                check = true;
            }
        } while (check);
    }

    /**
     * Print the information of triangle and it's perimeter and area.
     */
    @Override
    public void printResult() {
        System.out.println("----- Triangle -----");
        System.out.println("Side A: " + this.sideA);
        System.out.println("Side B: " + this.sideB);
        System.out.println("Side C: " + this.sideC);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    /**
     * Calculate the Area.
     *
     * @return a double present for area.
     */
    @Override
    public double getArea() {
        double p = getPerimeter();
        return Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
    }

    /**
     * Calculate the perimeter.
     *
     * @return a double present for perimeter.
     */
    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

}
