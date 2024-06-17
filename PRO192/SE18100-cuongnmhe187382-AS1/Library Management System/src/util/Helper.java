/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constant.IConstant;

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

  /**
   * check if user's want to continue or not
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
