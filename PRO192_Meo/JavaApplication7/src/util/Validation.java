/*
    Student ID   : HE187382
    Student name : Nguyễn Minh Cường
    Due date     : 
 */
package util;

import java.util.Scanner;

/**
 *
 * @author cuongnmhe187382
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Prompts the user to input an integer within a specified range and validates it.
     * 
     * @param inputMsg       The message prompting the user to input an integer.
     * @param errorMsgFormat The error message to display if the input is not a valid integer.
     * @param errorMsgRange  The error message to display if the input is outside the specified range.
     * @param lowerBound     The lower bound of the allowed range for the input integer.
     * @param upperBound     The upper bound of the allowed range for the input integer.
     * @return An integer within the specified range, or the default value if the user chooses not to continue.
     */
    public static int getAnInteger(String inputMsg, String errorMsgFormat, String errorMsgRange, int lowerBound, int upperBound) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println(errorMsgFormat);
            } catch (Exception e) {
                System.out.println(errorMsgRange);
            }
        }
    }

    /**
     * Prompts the user to input an integer within a specified range and validates it. 
     * 
     * @param inputMsg       The message prompting the user to input an integer.
     * @param errorMsgFormat The error message to display if the input is not a valid integer.
     * @param errorMsgRange  The error message to display if the input is outside the specified range.
     * @param lowerBound     The lower bound of the allowed range for the input integer.
     * @param upperBound     The upper bound of the allowed range for the input integer.
     * @return An integer within the specified range, or the default value if the user chooses not to continue.
     */
    public static double getADouble(String inputMsg, String errorMsgFormat, String errorMsgRange, double lowerBound, double upperBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println(errorMsgFormat);
            } catch (Exception e) {
                System.out.println(errorMsgRange);
            }
        }
    }

    /**
     * Prompts the user to input a string according to specified requirements
     * and validates it.
     *
     * @param inputMsg          The message prompting the user to input a string.
     * @param errorMsgEmpty     The error message to display if the input string is
     *                          empty.
     * @param errorMsgFormat    The error message to display if the input string
     *                          does not match the specified format.
     * @param format            The regular expression representing the desired format of
     *                          the input string.
     * @param length            The length of the input string.
     * @return A validated string matching the specified format and length.
     */
    public static String getAString(String inputMsg, String errorMsgEmpty, String errorMsgFormat, String format, int length) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsgEmpty);
            }
            if (match == false) {
                System.out.println(errorMsgFormat);
            } else {
                return id;
            }
        }
    }

    /**
     * Prompts the user to input a string and validates it for non-emptiness.
     * 
     * @param inputMsg The message prompting the user to input a string.
     * @param errorMsg The error message to display if the input string is empty.
     * @return A non-empty string entered by the user.
     */
    public static String getAString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
}
