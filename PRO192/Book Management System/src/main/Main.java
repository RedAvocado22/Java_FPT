/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.BookBo;
import constant.IConstant;
import mock.Data;
import util.Helper;
import util.MenuUI;
import util.Validate;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

  public static void main(String[] args) {
    String code;
    int choice, index;
    
    BookBo bookBo = new BookBo(Data.listBook);
    
    MenuUI menu = new MenuUI("Book Management System");
    menu.addNewOption("1. Add new book.");
    menu.addNewOption("2. Display.");
    menu.addNewOption("3. Search by code.");
    menu.addNewOption("4. Update price by code.");
    menu.addNewOption("5. The most expensive book.");
    menu.addNewOption("6. Sort by code.");
    menu.addNewOption("7. Remove.");
    menu.addNewOption("8. Load data from the file.");
    menu.addNewOption("9. Exit.");
    
    do {
      menu.printMenu();
      choice = menu.getChoice();
      switch (choice) {
        case 1:
          bookBo.add();
          break;
          
        case 2:
          bookBo.display();
          break;
          
        case 3:
          code = Validate.getString("Enter book's code need to find: ", 
                                    "Invalidated code!", 
                                    IConstant.REGEX_CODE);
          index = bookBo.search(code);
          
          if(index > -1) {
            System.out.println("Found the book!");
            if(Helper.isPrintOut()) {
              bookBo.displayOne(index);
            }
          } else {
            System.out.println("Not found the book!");
          }
          break;
          
        case 4:
          code = Validate.getString("Enter book's code need to update price: ", 
                                    "Invalidated code!", 
                                    IConstant.REGEX_CODE);
          index = bookBo.search(code);
          
          if (index > -1) {
            System.out.println("Found the book!");
            System.out.println("Here is the information of the book.");
            
            bookBo.displayOne(index);
            bookBo.updatePrice(index);
            System.out.println("Update succesful!");
          } else {
            System.out.println("Not found the book!");
          }
          break;
          
        case 5:
          System.out.println("Here is the most expensive book!");
          bookBo.mostExpensive().display();
          break;
          
        case 6:
          bookBo.sort();
          System.out.println("Books is sorted!");
          if(Helper.isPrintOut()) {
            bookBo.display();
          } else {
            System.out.println("Allright!!!");
          }
          break;
          
        case 7:
          code = Validate.getString("Enter book's code need to delete: ", 
                                    "Invalidated code!", 
                                    IConstant.REGEX_CODE);
          index = bookBo.search(code);
          
          if(index > -1) {
            System.out.println("Found the book!");
            System.out.println("Here is the information of the book to delete.");
            bookBo.displayOne(index);
            if(Helper.isContinue()) {
              bookBo.remove(index);
              System.out.println("Remove succesful!");
            } else {
              System.out.println("Cancel!");
            }
          } else {
            System.out.println("Not found the book!");
          }
          break;
        case 8:
          bookBo.takeData();
          break;
      }
    } while (choice != 9);
  }
}
