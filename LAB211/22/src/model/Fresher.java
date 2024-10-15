/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

import constant.IConstant;
import util.Helper;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Fresher extends Candidate{
    
    private int graduatedDate;
    private String graduationRank;
    private String educaiton;

    public Fresher() {
    }

    public Fresher(
            int id, 
            String firstName, String lastName, int birthDate, 
            String address, String phone, String email, int type,
            int graduatedDate, String graduationRank, String educaiton
    ) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.graduatedDate = graduatedDate;
        this.graduationRank = graduationRank;
        this.educaiton = educaiton;
    }

    public int getGraduatedDate() {
        return graduatedDate;
    }

    public void setGraduatedDate(int graduatedDate) {
        this.graduatedDate = graduatedDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducaiton() {
        return educaiton;
    }

    public void setEducaiton(String educaiton) {
        this.educaiton = educaiton;
    }

    private String generateRank() {
        Helper.menuOfRank();
        
        int choice = Validate.getInt(
                "Choice: ", 
                "Out of range!", 
                "Invalidated!", 
                1, 4
        );

        switch (choice) {
            case 1 -> {
                return "Excellence";
            }
            case 2 -> {
                return "Good";
            }
            case 3 -> {
                return "Fair";
            }
            case 4 -> {
                return "Poor";
            }
        }
        
        return "";
    }
    
    @Override
    public void input(int id) {
        this.graduatedDate = Validate.getInt(
                "Enter graduted date: ", 
                "Out of range!", 
                IConstant.INTEGER_MES,
                1980, Helper.getCurrentYear()
        );
        
        this.graduationRank = generateRank();
        
        this.educaiton = Validate.getString(
                "Enter university: ", 
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );
        
        super.setType(IConstant.FRESHER_TYPE);
    }
}
