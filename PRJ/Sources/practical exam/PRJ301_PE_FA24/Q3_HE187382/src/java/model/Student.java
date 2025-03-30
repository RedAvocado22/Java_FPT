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
public class Student {
    
    private String id, name, birthDate, gender, subjectId, subjectName;

    public Student() {
    }

    public Student(String id, String name, String birthDate, String gender, String subjectId, String subjectName) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", subjectId=" + subjectId + '}';
    }
    
}
