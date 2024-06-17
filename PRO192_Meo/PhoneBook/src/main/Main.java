/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.PhoneBo;
import constant.IConstant;
import mock.Data;
import util.MenuUI;
import util.Validate;

/**
 *
 * @author Admin
 */
public class Main {

  public static void main(String[] args) {
    int choice, index;
    String phoneNumber;
    
    MenuUI menu = new MenuUI("Phone book Manager");
    menu.addNewOption("1. Insert phone number.");
    menu.addNewOption("2. Search phone number.");
    menu.addNewOption("3. Delete phone number.");
    menu.addNewOption("4. Display phone book.");
    menu.addNewOption("5. Exit.");

    PhoneBo phoneBo = new PhoneBo(Data.listPhone);
    
    do {
      menu.printMenu();
      choice = menu.getChoice();

      switch (choice) {
        case 1:
          MenuUI menuInsert = new MenuUI("Phone book Insert.");
          menuInsert.addNewOption("1. Insert phone number in last position.");
          menuInsert.addNewOption("2. Insert phone number in specific position.");
          menuInsert.addNewOption("3. Exit.");
          do {
            menuInsert.printMenu();
            choice = menuInsert.getChoice();

            switch (choice) {
              case 1:
                phoneBo.insertLast();
                break;
              case 2:
                index = Validate.getInt("Enter index you want to insert: ",
                        "Index invalidated! Try again!",
                        "Index must be an integer!",
                        0, phoneBo.size());
                phoneBo.insertByIndex(index);
                break;
            }
          } while (choice != 3);
          break;
        case 2:
          phoneNumber = Validate.getString("Enter phone number need to search: ",
                                           "Invalidated phone number! Try again!", 
                                           IConstant.REGEX_PHONE_NUMBER);
          phoneBo.searchPhoneNumber(phoneNumber);
          break;
        case 3:
          MenuUI menuDelete = new MenuUI("Phone book Delete.");
          menuDelete.addNewOption("1. Delete phone number by index.");
          menuDelete.addNewOption("2. Delete phone number by phone number.");
          menuDelete.addNewOption("3. Exit.");

          do {
            menuDelete.printMenu();
            choice = menuDelete.getChoice();

            switch (choice) {
              case 1:
                index = Validate.getInt("Enter index you want to delete: ",
                        "Index invalidated! Try again!",
                        "Index must be an integer!",
                        0, phoneBo.size());
                phoneBo.deleteByIndex(index);
                break;
              case 2:
                phoneNumber = Validate.getString("Enter phone number need to delete: ",
                                                 "Invalidated phone number! Try again!",
                                                 IConstant.REGEX_PHONE_NUMBER);
                phoneBo.deleteByPhoneNumber(phoneNumber);
                break;
            }
          } while (choice != 3);
          break;
        case 4:
          phoneBo.display();
          break;
      }
    } while (choice != 5);
  }

}
