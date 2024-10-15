/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

import constant.IConstant;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Intern extends Candidate {

    private String major, education;
    private int semester;

    public Intern() {
    }

    public Intern(
            int id,
            String firstName, String lastName, int birthDate,
            String address, String phone, String email, int type,
            String major, int semester, String education
    ) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void input(int id) {
        super.input(id); 
        
        this.education = Validate.getString(
                "Enter university: ",
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );
        
        this.major = Validate.getString("Enter major: ", IConstant.STRING_MES, IConstant.REGEX_NAME);
        
        this.semester = Validate.getInt(
                "Enter semester: ", 
                IConstant.RANGE_MES, 
                IConstant.INTEGER_MES, 
                IConstant.MIN_SEMESTER, 
                IConstant.MAX_SEMESTER
        );
        
        super.setType(IConstant.INTERN_TYPE);
    }
}
