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
public class Intern extends Candidate {

    private String major;
    private int semester;
    private String university;

    public Intern() {
    }

    public Intern(
            int id,
            String firstName,
            String lastName,
            int birthDate,
            String address,
            String phone,
            String email,
            int type,
            String major,
            int semester,
            String university) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * setting intern attributes through user input validation and set candidate
     * to intern type
     *
     * @param list the list of candidates to check for duplicate IDs when
     * getting a new ID
     */
    @Override
    public void input(List<Candidate> list) {
        super.input(list);
        this.major = Validate.getString(
                "Enter major: ",
                "Input must be in correct format",
                IConstant.REGEX_TEXT);

        this.semester = Validate.getInt(
                "Enter semester: ",
                "Numeric value out of range",
                "Invalid integer number",
                IConstant.MIN_SEMESTER,
                IConstant.MAX_SEMESTER);

        this.university = Validate.getString(
                "Enter university: ",
                "Invalid university",
                IConstant.REGEX_TEXT);

        this.setType(IConstant.INTERN_TYPE);

    }
}
