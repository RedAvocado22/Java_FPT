/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package util;

import constant.IConstant;

/**
 *
 * @author Minh Cuong
 */
public class Helper {

    private Helper() {

    }

    /**
     * Display menu for user to choose.
     */
    public static void menu() {
        System.out.println("\n===== Shopping Program =====");
    }

    /**
     * Check if user's want to continue or not
     *
     * @return true if input = Y, false if not
     */
    public static boolean isContinue() {
        String respond = Validate.getString(
                "Do you want to continue?",
                "Only choose Y/N",
                IConstant.REGEX_YES_NO);
        return respond.equalsIgnoreCase(IConstant.YES);
    }

}
