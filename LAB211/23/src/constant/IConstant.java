/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package constant;

/**
 *
 * @author Minh Cuong
 */
public interface IConstant {

    String INTEGER_MES = "It must be an integer!";
    String DOUBLE_MES = "It must be a double!";
    String POSITIVE_MES = "It must be a positive number!";
    String STRING_MES = "Invalidated!";

    String REGEX_NAME = "^[A-Za-z ]+$";
    String REGEX_ID = "^[A-Za-z0-9 ]+$";
    String REGEX_ADDRESS = "^[A-Za-z0-9 ]+$";

    int MIN_AGE = 18;
    int MAX_AGE = 50;

    String REGEX_YES_NO = "^[yYnN]$";
    String YES = "y";

    String UP = "UP";
    String DOWN = "DOWN";
}
