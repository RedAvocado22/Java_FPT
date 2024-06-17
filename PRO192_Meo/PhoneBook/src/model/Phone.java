/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.IConstant;
import util.Validate;

/**
 *
 * @author Admin
 */
public class Phone {

  private String name, phoneNumber;

  public Phone() {
  }

  public Phone(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
  
  /**
   * Add a new phone number and its user's name.
   */
  public void input() {
    this.name = Validate.getString("Enter phone number user's name: ", 
                                   "Invalidated name! Try again!", 
                                    IConstant.REGEX_NAME);
    
    this.phoneNumber = Validate.getString("Enter phone number: ", 
                                    "Invalidated phone number! Try again!", 
                                    IConstant.REGEX_PHONE_NUMBER);
  }
  
  /**
   * Display phone number and its user's name.
   */
  public void display() {
    System.out.printf("%-19s|%15s\n", name, phoneNumber);
  }
}
