/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Helper {

  public static String getCurrentDate(final String FORMAT) {
    SimpleDateFormat dateformatted = new SimpleDateFormat(FORMAT);

    Date date = new Date();

    return dateformatted.format(date);
  }
}
