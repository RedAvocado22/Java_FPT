/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.IConstant;
import java.util.List;
import util.Validate;

/**
 *
 * @author Admin
 */
public class Student {
    private String code;
    private String name;
    private double mark;

    public Student() {
    }

    public Student(String code, String name, double mark) {
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
        this.mark = (mark >= 0 && mark <= 10) ? mark : 0;
    }

    public String getCode() {
        return code;
    }

    public void setName() {
        this.name = Validate.getString("Enter student's name: ", 
                                        "Error name!",
                                        IConstant.REGEX_NAME);
    }

    public void setMark() {
        this.mark = this.mark = Validate.getDouble("Enter mark: ", 
                                        "Mark must be between from 0 to 10!", 
                                        "Mark must be a digit", 
                                        IConstant.MIN_MARK, IConstant.MAX_MARK);
    }

    /**
     * Get id from input validation
     *
     * @param list the list to loop through to check if id is duplicated or not
     * @return valid id from input
     */
    private String getId(List<Student> list) {
        while (true) {
            String code = Validate.getString("Enter student's code: ", "Error student code!",
                    IConstant.REGEX_CODE);

            boolean isExist = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCode().trim().equalsIgnoreCase(code)) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("Code is exist, try again");
            } else {
                return code;
            }
        }
    }
  
    public void input(List<Student> list) {
        this.code = getCode();
        
        this.name = Validate.getString("Enter student's name: ", 
                                        "Error name!",
                                        IConstant.REGEX_NAME);
        
        this.mark = Validate.getDouble("Enter mark: ", 
                                        "Mark must be between from 0 to 10!", 
                                        "Mark must be a digit", 
                                        IConstant.MIN_MARK, IConstant.MAX_MARK);
    }
    
    public void display() {
        System.out.printf("Code: %-10s| Name: %-20s| Mark: %5.2f", code, name, mark);
    }
    
    public static String normalizeName(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder normalized = new StringBuilder();
        boolean toUpperCase = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '_') {
                toUpperCase = true;
            } else {
                if (toUpperCase) {
                    normalized.append(Character.toUpperCase(currentChar));
                    toUpperCase = false;
                } else {
                    normalized.append(Character.toLowerCase(currentChar));
                }
            }
        }
        
        normalized.setCharAt(0, Character.toLowerCase(normalized.charAt(0)));

        return normalized.toString();
    }
}
