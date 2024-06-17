/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author Admin
 */
public interface IConstant {

  String REGEX_CODE = "^[A-Za-z0-9 ]+$";
  String REGEX_NAME = "^[A-Za-z ]+$";
  String REGEX_TEXT = "^[A-Za-z0-9 ]+$";
  String REGEX_FILE = "^.+\\.txt$";
  String REGEX_PHONE_NUMBER = "^[0-9]{10,}$";
  String REGEX_YES_NO = "^[yYnN]$";

  String YES = "y";
}
