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
public class Candidate {

    private int id;
    private String firstName, lastName;
    private int birthDate;
    private String address, phone, email;
    private int type;

    public Candidate() {
    }

    public Candidate(
            int id,
            String firstName, String lastName,
            int birthDate,
            String address,
            String phone, String email,
            int type
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void input(int id) {
        this.id = id;

        this.firstName = Validate.getString(
                "Enter first name: ",
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );

        this.lastName = Validate.getString(
                "Enter last name: ",
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );

        this.birthDate = Validate.getInt(
                "Enter birth date: ",
                IConstant.RANGE_MES,
                IConstant.INTEGER_MES,
                1990, Helper.getCurrentYear()
        );

        this.address = Validate.getString(
                "Enter address: ",
                IConstant.STRING_MES,
                IConstant.REGEX_ADDRESS
        );

        this.phone = Validate.getString(
                "Enter phone: ",
                IConstant.STRING_MES,
                IConstant.REGEX_PHONE_NUMBER
        );

        this.email = Validate.getString(
                "Enter email: ",
                IConstant.STRING_MES,
                IConstant.REGEX_EMAIL
        );
    }

    public void display() {
        System.out.printf(
                "\n%-5d%-20s%-15d%-10s%-15s%-25s%-10d",
                this.id, getFullName(), this.birthDate,
                this.address, this.phone, this.email, this.type
        );
    }
}
