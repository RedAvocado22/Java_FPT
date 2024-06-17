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
   * @param msgNotice the prompt from user.
   * @return true if input = Y, false if not
   */
  public static boolean isContinue(String msgNotice) {
    String respond = Validate.getString(
      msgNotice + " ",
      "Only choose Y/N",
      IConstant.REGEX_YES_NO
    );
    return respond.equalsIgnoreCase(IConstant.YES);
  } 
}
