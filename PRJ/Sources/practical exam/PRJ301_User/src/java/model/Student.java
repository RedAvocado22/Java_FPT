/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Teacher
 */
// Student s;
// List<Student> students;
public class Student {
    private int studentID;
    private String fullName;
    private String gender;
    private int courseID;

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public int getCourseID() {
        return courseID;
    }

    public Student() {
    }

    // constructors, getters, and setters

    public Student(int studentID, String fullName, String gender, int courseID) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gender = gender;
        this.courseID = courseID;
    }
    
    private String courseName; // Thêm trường courseName vào lớp Student

    // Các phương thức getter và setter cho courseName
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

