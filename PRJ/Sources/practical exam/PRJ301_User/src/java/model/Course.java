/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Teacher
 */
public class Course {
    private int courseID;
    private String courseName;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    // constructors, getters, and setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public Course() {
    }
    
    
}

