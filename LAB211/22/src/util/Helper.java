/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package util;

import constant.IConstant;
import java.util.Calendar;

/**
 *
 * @author Minh Cuong
 */
public class Helper {

    private Helper() {
    }

    /**
     * get the current year as an integer.
     *
     * @return the current year as an integer
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Display menu for user to choose.
     */
    public static void menu() {
        System.out.println("\n========= CANDIDATE MANAGEMENT =========");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Search");
        System.out.println("5. Exit");
    }

    public static void menuOfCandidateType() {
        System.out.println("\n========= TYPE =========");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
    }

    public static void menuOfRank() {
        System.out.println("\n========= Rank =========");
        System.out.println("1. Excellence");
        System.out.println("2. Good");
        System.out.println("3. Fair");
        System.out.println("4. Poor");
    }

    /**
     * Check if user's want to continue or not
     *
     * @return true if input = Y, false if not
     */
    public static boolean isContinue() {
        String respond = Validate.getString(
                "Do you want to continue? ",
                "Only choose Y/N",
                IConstant.REGEX_YES_NO);
        return respond.equalsIgnoreCase(IConstant.YES);
    }

}
