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

  String REGEX_NAME = "^[A-Za-z ]+$";
  String REGEX_PHONE_NUMBER = "^[0-9]{10,}$";
  String REGEX_YES_NO = "^[yYnN]$";
  String REGEX_CODE = "\"^[S ]\\\\d{3}$\"";
  
  String MARK_TYPE = "M";
  String NAME_TYPE = "N";
  
  double MAX_MARK = 10;
  double MIN_MARK = 0;
  String YES = "y";
}
