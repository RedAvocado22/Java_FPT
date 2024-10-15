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
    String RANGE_MES = "Out of range!";
    String STRING_MES = "Invalidated string!";
    String POSITIVE_MES = "It must be positive!";

    String REGEX_NAME = "^[A-Za-z ]+$";
    String REGEX_ID = "^[A-Za-z0-9 ]+$";
    String REGEX_ADDRESS = "^[A-Za-z0-9 ]+$";
    String REGEX_PHONE_NUMBER = "^[0-9]{10,}$";
    String REGEX_EMAIL = "^[\\w]+@[\\w.]+\\.[A-Za-z]{2,}$";
	String REGEX_TEXT = "^[A-Za-z0-9 ,\\.]+$";
    
    int MIN_YEAR = 1900;
	int EXPERIENCE_TYPE = 0;
	int FRESHER_TYPE = 1;
	int INTERN_TYPE = 2;
	int MIN_SEMESTER = 1;
	int MAX_SEMESTER = 9;
    
    String REGEX_YES_NO = "^[yYnN]$";
    String YES = "y";

	String SEARCH_NAME_ONLY = "Search name only";
	String SEARCH_NAME_AND_TYPE = "Search name and type";
	String DISPLAY_NAME_ONLY = "Display name only";
}
