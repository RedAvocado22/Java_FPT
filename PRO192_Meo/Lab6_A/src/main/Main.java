/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.StudentBo;
import constant.IConstant;
import util.Helper;
import util.MenuUI;
import util.Validate;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        int choice, index;
        String code;
        
        MenuUI menu = new MenuUI("Student Mangement System");
        menu.addNewOption("1. Add new student.");
        menu.addNewOption("2. Search student.");
        menu.addNewOption("3. Update name or mark of student.");
        menu.addNewOption("4. Remove student");
        menu.addNewOption("5. List all student.");
        menu.addNewOption("6. Exit");
        
        StudentBo studentBo = new StudentBo();
        
        do {
            menu.printMenu();
            choice = menu.getChoice();
            
            switch(choice) {
                case 1:
                    studentBo.add();
                    break;
                case 2:
                    code = Validate.getString("Enter student's code you need to find: ", 
                                               "Error code!", 
                                               IConstant.REGEX_CODE);
                    
                    index = studentBo.search(code);
                    System.out.println("Here is the student you need: ");
                    studentBo.displayOne(index);
                    break;
                case 3:
                    code = Validate.getString("Enter student's code you need to find: ", 
                                               "Error code!", 
                                               IConstant.REGEX_CODE);
                    index = studentBo.search(code);
                    System.out.println("Here is the student you need: ");
                    studentBo.displayOne(index);
                    
                    MenuUI menuUpdate = new MenuUI("Update");
                    menuUpdate.addNewOption("1. Update name.");
                    menuUpdate.addNewOption("2. Update mark.");
                    menuUpdate.addNewOption("3. Exit.");

                    choice = menuUpdate.getChoice();
                    
                    if(choice == 1) {
                        studentBo.update(index, IConstant.NAME_TYPE);
                    } else {
                        studentBo.update(index, IConstant.MARK_TYPE);
                    }
                    break;
                case 4:
                    code = Validate.getString("Enter student's code you need to find: ", 
                                               "Error code!", 
                                               IConstant.REGEX_CODE);
                    
                    index = studentBo.search(code);
                    System.out.println("Here is student you want to remove: ");
                    studentBo.displayOne(index);
                    
                    if (Helper.isContinue()) {
                        studentBo.remove(index);
                    } else {
                        System.out.println("Cancel!");
                    }
                    break;
                case 5: 
                    studentBo.display();
                    break;
            }
        } while(choice >= 1 && choice <= 5);
    }

}
