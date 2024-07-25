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
	String REGEX_EMAIL = "^[\\w-\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String REGEX_ADDRESS = "^[A-Za-z0-9 ,\\-\\./]+$";
	String REGEX_TEXT = "^[A-Za-z0-9 ,\\.]+$";
	String REGEX_YES_NO = "^[yYnN]$";

	String YES = "y";
	int MIN_YEAR = 1900;
	int EXPERIENCE_TYPE = 0;
	int FRESHER_TYPE = 1;
	int INTERN_TYPE = 2;
	int MIN_SEMESTER = 1;
	int MAX_SEMESTER = 9;
	String SEARCH_NAME_ONLY = "Search name only";
	String SEARCH_NAME_AND_TYPE = "search name and type";
	String DISPLAY_NAME_ONLY = "display name only";
}
