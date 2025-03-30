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
public class Doctor {
    
    private int id;
    private String fullName, specialty;
    private int departmentId;

    public Doctor() {
    }

    public Doctor(int id, String fullName, String specialty, int departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.specialty = specialty;
        this.departmentId = departmentId;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", fullName=" + fullName + ", specialty=" + specialty + ", departmentId=" + departmentId + '}';
    }
}
