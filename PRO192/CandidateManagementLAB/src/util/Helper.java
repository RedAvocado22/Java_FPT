/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constant.IConstant;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class Helper {
    //Lớp Helper được tạo ra để chứa các phương thức hữu ích,
    //được sử dụng để hỗ trợ các hoạt động trong ứng dụng. Thông thường,
    //lớp Helper chứa các phương thức tĩnh (static methods) để có thể sử dụng mà không cần tạo một đối tượng mới.
    // constructor to limit creating new instances of this class

    private Helper() {

    }

//    /**
//     * display menu for user to choose
//     */
    public static void menu() {
        System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Search");
        System.out.println("5. Exit");
    }

    /**
     * check if user's want to continue or not
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

    /**
     * get the current year as an integer.
     *
     * @return the current year as an integer
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    } //Phương thức getCurrentYear() được sử dụng để lấy năm hiện tại dưới dạng một số nguyên.
}
