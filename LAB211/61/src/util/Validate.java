/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Minh Cuong
 */
public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Don't let anyone instantiate this class.
     */
    private Validate() {
    }

    /**
     * Return the valid integer value scanned from the input.
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input.
     * @param messageErrorOutOfRange    the message will be printed if the String
     *                                  parse value is out of range.
     * @param messageErrorInvalidNumber the message will be printed if the
     *                                  String does not contain a valid integer
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @return the valid integer value scanned from the input.
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
	 * Return the valid double value scanned from the input.
	 *
	 * @param messageInfo               the message to be printed instructing
	 *                                  the user to input.
	 * @param messageErrorOutOfRange    the message will be printed if the
	 *                                  String parse value is out of range.
	 * @param messageErrorInvalidNumber the message will be printed if the
	 *                                  String does not contain a valid integer
	 * @param min                       minimum limit value
	 * @param max                       maximum limit value
	 * @return the valid double value scanned from the input.
	 */
    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            double min, double max) {
        do {
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
	 * Return a valid String scanned from the input.
	 *
	 * @param messageInfo  the message printed instructing the user to input.
	 * @param messageError the message will be printed when the input String
	 *                     does not match the regular expression.
	 * @param REGEX        the pattern to test String is valid or not
	 * @return a String - an operator
	 */
    public static String getString(
            String messageInfo,
            String messageError,
            final String REGEX) {
        do {
            System.out.print(messageInfo);
            String string = SCANNER.nextLine();
            if (string.matches(REGEX)) {
                return string.trim();
            }
            System.out.println(messageError);
        } while (true);

    }
}
