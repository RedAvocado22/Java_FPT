/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.IConstant;
import java.util.List;
import util.Helper;
import util.Validate;

public class Candidate {

    private int id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int type;

    public Candidate() {
    }

    public Candidate(
            int id,
            String firstName,
            String lastName,
            int birthDate,
            String address,
            String phone,
            String email,
            int type) {
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

    /**
     * Displays information about the object worker
     */
    public void display() {
        System.out.printf("%-5d %-20s %-20s %-10d %-30s %-15s %-30s %-10d%n",
                this.id,
                this.firstName, this.lastName, this.birthDate, this.address,
                this.phone, this.email, this.type);

    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * get id from input validation
     *
     * @param list the list to loop through to check if id is duplicated or not
     * @return valid id from input
     */
    private int getId(List<Candidate> list) {
//		do {
//			int id = Validate.getInt(
//					"Enter ID: ",
//					"Numeric value out of range",
//					"Invalid integer number",
//					1,
//					Integer.MAX_VALUE);
//			boolean isExist = list.stream().anyMatch(c -> c.getId() == id); // phương thức sử dụng phương thức anyMatch()
//                                                                                        //của Stream để kiểm tra xem ID đã nhập có tồn tại trong danh sách các ứng viên hay không
//			if (isExist) {
//				System.out.println("ID is exist, try again");
//			} else {
//                            
//				return id;
//			}
//		} while (true);
        while (true) {
            int id = Validate.getInt(
                    "Enter ID: ",
                    "Numeric value out of range",
                    "Invalid integer number",
                    1,
                    Integer.MAX_VALUE);

            boolean isExist = false;
            for (Candidate candidate : list) {
                if (candidate.getId() == id) {
                    isExist = true;
                    break; // Khi tìm thấy một ID tồn tại, thoát khỏi vòng lặp
                }
            }

            if (isExist) {
                System.out.println("ID is exist, try again");
            } else {
                return id;
            }
        }
    }

    /**
     * setting candidate attributes through user input validation.
     *
     * @param list the list of candidates to check for duplicate IDs when
     * getting a new ID
     */
    public void input(List<Candidate> list) {
        this.id = getId(list);
        this.firstName = Validate.getString(
                "Enter first name: ",
                "Input must be in correct format",
                IConstant.REGEX_NAME);

        this.lastName = Validate.getString(
                "Enter last name:",
                "Input must be in correct format",
                IConstant.REGEX_NAME);

        this.birthDate = Validate.getInt(
                "Enter birth date: ",
                "Numeric value out of range",
                "Invalid integer number",
                IConstant.MIN_YEAR,
                Helper.getCurrentYear());

        this.address = Validate.getString(
                "Enter address: ",
                "Invalid address",
                IConstant.REGEX_ADDRESS);

        this.phone = Validate.getString(
                "Enter phone number: ",
                "Invalid phone number",
                IConstant.REGEX_PHONE_NUMBER);
        this.email = Validate.getString(
                "Enter email: ",
                "Invalid email",
                IConstant.REGEX_EMAIL);
    }
}
