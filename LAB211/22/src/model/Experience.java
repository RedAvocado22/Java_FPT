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
public class Experience extends Candidate {

    private int yearOfExp;
    private String proSkill;

    public Experience() {
    }

    public Experience(int yearOfExp, String proSkill) {
        this.yearOfExp = yearOfExp;
        this.proSkill = proSkill;
    }

    public Experience(
            int id,
            String firstName,
            String lastName,
            int birthDate,
            String address,
            String phone,
            String email,
            int type,
            int yearOfExp,
            String proSkill
    ) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.yearOfExp = yearOfExp;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return yearOfExp;
    }

    public String getProSkill() {
        return proSkill;
    }

    @Override
    public void input(int id) {
        super.input(id);

        this.yearOfExp = Validate.getInt(
                "Enter year of experience: ",
                "Numeric value out of range.",
                IConstant.INTEGER_MES,
                1, 100);

        this.proSkill = Validate.getString(
                "Enter professional skill: ",
                "Invalid skill",
                IConstant.REGEX_TEXT);

        this.setType(IConstant.EXPERIENCE_TYPE);
    }
}
