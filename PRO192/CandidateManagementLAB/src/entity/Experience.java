/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.IConstant;
import java.util.List;
import util.Validate;


public class Experience extends Candidate {

    private int yearOfExp;
    private String proSkill;

    public Experience() {
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
            String proSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.yearOfExp = yearOfExp;
        this.proSkill = proSkill;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    /**
     * setting experience attributes through user input validation and set
     * candidate to experience type
     *
     * @param List the list of candidates to check for duplicate IDs when
     * getting a new ID
     */
    @Override
    public void input(List<Candidate> List) {
        super.input(List);
        this.yearOfExp = Validate.getInt(
                "Enter year of experience: ",
                "Numeric value out of range.",
                "Invalid integer number.",
                1, 100);
        this.proSkill = Validate.getString(
                "Enter professional skill: ",
                "Invalid skill",
                IConstant.REGEX_TEXT);
        this.setType(IConstant.EXPERIENCE_TYPE);
    }

}
