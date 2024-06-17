/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package util;

import constant.IConstant;

/**
 *
 * @author Admin
 */
public class Helper {

  private Helper() {
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
  
  /**
   * Check if user's want to print or not
   *
   * @return true if input = Y, false if not
   */
  public static boolean isPrintOut() {
    String respond = Validate.getString(
            "Do you want to print out the information? ",
            "Only choose Y/N",
            IConstant.REGEX_YES_NO);
    return respond.equalsIgnoreCase(IConstant.YES);
  }
}
