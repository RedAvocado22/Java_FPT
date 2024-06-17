/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

import util.Validate;

/**
 *
 * @author Admin
 */
public class Fraction {

  private int numerator;
  private int denominator;

  public Fraction() {
  }

  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }

  /**
   * Create a new fraction.
   */
  public void input() {
    this.numerator = Validate.getInt("Enter numberator: ",
            "Mumberator is out of range!",
            "Numberator must a digit",
            Integer.MIN_VALUE, Integer.MAX_VALUE);

    do {
      this.denominator = Validate.getInt("Enter denominator: ",
              "Denominator is out of range!",
              "Denominator must a digit!",
              Integer.MIN_VALUE, Integer.MAX_VALUE);
      if (this.denominator == 0) {
        System.out.println("Denominator can't be zero!");
      }
    } while (this.denominator == 0);
  }

  /**
   * Display fraction.
   */
  public void display() {
    System.out.println(numerator + "/" + denominator);
  }
}
