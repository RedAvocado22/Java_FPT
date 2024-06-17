/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import logic.FractionCaculator;
import model.Fraction;
import util.Validate;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

  public static void main(String[] args) {
    Fraction f1 = new Fraction();
    Fraction f2 = new Fraction();

    int choice;

    do {
      menu();
      choice = Validate.getInt("Enter choice: ", 
                               "Choice must be in 1 - 5.",
                               "Choice must be a digit!", 
                               1, 5);
      
      switch(choice) {
        case 1: 
          System.out.println("Enter first fraction: ");
          f1.input();
          System.out.println("Enter second fraction: ");
          f2.input();
          System.out.println("Result: ");
          System.out.print("Sum of them: ");
          FractionCaculator.add(f1, f2).display();
          break;
        case 2:
          System.out.println("Enter first fraction: ");
          f1.input();
          System.out.println("Enter second fraction: ");
          f2.input();
          System.out.print("Substract of them: ");
          FractionCaculator.subtract(f1, f2).display();
          break;
        case 3:
          System.out.println("Enter first fraction: ");
          f1.input();
          System.out.println("Enter second fraction: ");
          f2.input();
          System.out.print("Mul. of them: ");
          FractionCaculator.multiply(f1, f2).display();
          break;
        case 4:
          System.out.println("Enter first fraction: ");
          f1.input();
          System.out.println("Enter second fraction: ");
          f2.input();
          System.out.print("Div. of them: ");
          FractionCaculator.divide(f1, f2).display();
          break;
        case 5:
          System.out.println("Enter fraction need to reduce: ");
          f1.input();
          FractionCaculator.simplify(f1);
          System.out.print("Fraction after simplify: ");
          f1.display();
          break;
      }
    } while (choice != 6);
  }

  private static void menu() {
    System.out.println("\n========== Fraction ==========");
    System.out.println("1. Adds fraction.");
    System.out.println("2. Substracts fraction.");
    System.out.println("3. Multiply fraction.");
    System.out.println("4. Divide fraction.");
    System.out.println("5. Reduce.");
    System.out.println("6. Exit.");
  }
}
