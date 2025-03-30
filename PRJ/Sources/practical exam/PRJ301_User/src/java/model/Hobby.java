/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Teacher
 */
public class Hobby {
    private int hobbyID;
    private String hobbyName;

    public int getHobbyID() {
        return hobbyID;
    }

    public void setHobbyID(int hobbyID) {
        this.hobbyID = hobbyID;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Hobby(int hobbyID, String hobbyName) {
        this.hobbyID = hobbyID;
        this.hobbyName = hobbyName;
    }

    // constructors, getters, and setters

    public Hobby() {
    }
}

