/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;
import entity.Triangle;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== Calculator Shape Program =====");
        
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        Shape circle = new Circle();
        
        rectangle.input();
        circle.input();
        triangle.input();
        
        rectangle.printResult();
        circle.printResult();
        triangle.printResult(); 
    }
}
