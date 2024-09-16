/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package util;

import constant.IConstant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Minh Cuong
 */
public class Helper {

    private Helper() {
    }

    /**
     * Get the current local date in the "dd/MM/yyyy" format.
     * 
     * @return A string representing the current date in the "dd/MM/yyyy" format.
     */
    public static String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(formatter);
    }
    
    /**
     * Display menu for user to choose.
     */
    public static void menu() {
        System.out.println("\n========= Worker Management =========");
        System.out.println("1. Add worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display infoormation salary");
        System.out.println("5. Exit");
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
