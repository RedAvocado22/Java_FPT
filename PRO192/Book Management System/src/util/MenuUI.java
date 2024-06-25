/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MenuUI {

  private String menuTitle;
  private ArrayList<String> optionList = new ArrayList<>();

  public MenuUI(String menuTitle) {
    this.menuTitle = menuTitle;
  }

  /**
   * Get menu size.
   * 
   * @return size of menu.
   */
  public int getSize() {
    return optionList.size();
  }

  /**
   * Add new Option for menu.
   * 
   * @param newOption Option that need to add to menu.
   */
  public void addNewOption(String newOption) {
    optionList.add(newOption);
  }

  /**
   * Display menu.
   */
  public void printMenu() {
    if (optionList.isEmpty()) {
      System.out.println("There is no item in the menu");
      return;
    }
    System.out.println("\n------------------------------------");
    System.out.println("Welcome to " + menuTitle);
    for (String x : optionList) {
      System.out.println(x);
    }
  }

  /**
   * Get choice from user.
   * 
   * @return choice.
   */
  public int getChoice() {
    int maxOption = optionList.size();

    String inputMsg = "Choose [1.." + maxOption + "]: ";
    String errorMsg = "You are required to choose the option 1..." + maxOption;
    return Validate.getInt(inputMsg, errorMsg, "Choice must be a digit!", 1, maxOption);
  }
}
