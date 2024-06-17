/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package logic;

import model.Fraction;

/**
 *
 * @author Admin
 */
public class FractionCaculator {

  /**
   * Don't let anyone instantiate this class.
   */
  private FractionCaculator() {
  }
  
  /**
   * Adds the specified fraction to this fraction.
   *
   * @param thisFraction A fraction.
   * @param thatFaction  A fraction.
   * @return a new Fraction representing the sum of this fraction and the 
   * specified fraction
   */
  public static Fraction add(Fraction thisFraction, Fraction thatFaction) {
    int newNumerator = thisFraction.getNumerator() * thatFaction.getDenominator() + thatFaction.getNumerator() * thisFraction.getDenominator();
    int newDenominator = thisFraction.getDenominator() * thatFaction.getDenominator();
    return new Fraction(newNumerator, newDenominator);
  }

  
  /**
   * Subtract the specified fraction to this fraction.
   *
   * @param thisFraction A fraction.
   * @param thatFaction  A fraction.
   * @return a new Fraction representing the sum of this fraction and the 
   * specified fraction
   */
  public static Fraction subtract(Fraction thisFraction, Fraction thatFaction) {
    int newNumerator = thisFraction.getNumerator() * thatFaction.getDenominator() - thatFaction.getNumerator() * thisFraction.getDenominator();
    int newDenominator = thisFraction.getDenominator() * thatFaction.getDenominator();
    return new Fraction(newNumerator, newDenominator);
  }

  /**
   * Reduces this fraction by dividing both the numerator and denominator by
   * their greatest common divisor.
   */
  public static void simplify(Fraction fraction) {
    int numerator = fraction.getNumerator(), denominator = fraction.getDenominator();
    
    int gcd = gcd(numerator, denominator);
    fraction.setNumerator(numerator /= gcd);
    fraction.setDenominator(denominator /= gcd);
    fraction.display();
  }
  
  /**
   * Computes the greatest common divisor (GCD) of two integers using the
   * Euclidean algorithm.
   *
   * @param a the first integer
   * @param b the second integer
   * @return the greatest common divisor of {@code a} and {@code b}
   */
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return Math.abs(a);
  }
  
  /**
   * Multiplies the specified fraction with this fraction.
   *
   * @param thisFraction
   * @param thatFaction
   * @return a new {@code Fraction} representing the product of this fraction
   * and the specified fraction
   */
  public static Fraction multiply(Fraction thisFraction, Fraction thatFaction) {
    int newNumerator = thisFraction.getNumerator() * thatFaction.getNumerator();
    int newDenominator = thisFraction.getDenominator() * thatFaction.getDenominator();
    return new Fraction(newNumerator, newDenominator);
  }

  /**
   * Divides this fraction by the specified fraction.
   *
   * @param thisFraction
   * @param thatFaction
   * @return a new {@code Fraction} representing the quotient of this fraction
   * and the specified fraction
   * @throws IllegalArgumentException if the other fraction has a numerator of
   * zero (division by zero)
   */
  public static Fraction divide(Fraction thisFraction, Fraction thatFaction) {
    if (thisFraction.getNumerator() == 0 || thatFaction.getNumerator() == 0) {
      throw new IllegalArgumentException("Cannot divide by a fraction with a numerator of zero.");
    }
    int newNumerator = thisFraction.getNumerator() * thatFaction.getDenominator();
    int newDenominator = thisFraction.getDenominator() * thatFaction.getNumerator();
    return new Fraction(newNumerator, newDenominator);
  }
}
