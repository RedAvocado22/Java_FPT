/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

/**
 *
 * @author Minh Cuong
 */
public class Patient {
    
    private int id;
    private String fullName, gender, birthDate;

    public Patient() {
    }

    public Patient(int id, String fullName, String gender, String birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", fullName=" + fullName + ", gender=" + gender + ", birthDate=" + birthDate + '}';
    }
}
