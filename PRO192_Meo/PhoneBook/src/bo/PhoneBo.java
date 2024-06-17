/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import model.Phone;
import util.Helper;

/**
 *
 * @author Admin
 */
public class PhoneBo {

  private List<Phone> list = new ArrayList<>();

  public PhoneBo(List<Phone> listPhone) {
    this.list = listPhone;
  }

  /**
   * Take the size of phone book.
   *
   * @return The size of phone book.
   */
  public int size() {
    return list.size();
  }

  /**
   * Insert a new phone number in last position.
   */
  public void insertLast() {
    Phone newPhone = new Phone();
    do {
      newPhone.input();
      if (newPhone != null) {
        list.add(newPhone);
      } else {
        System.out.println("An error has occurred. Can not add new candidate");
      }
    } while (Helper.isContinue());
  }

  /**
   * Insert a new phone number in specific index.
   *
   * @param index The position user want to add a new phone number.
   */
  public void insertByIndex(int index) {
    Phone phone = new Phone();
    do {
      phone.input();
      this.list.add(index, phone);
    } while (Helper.isContinue());
  }

  /**
   * Search phone number.
   *
   * @param phoneNumber Phone number user need to find.
   * @return position of phone number.
   */
  public int searchPhoneNumber(String phoneNumber) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
        if (Helper.isPrintOut()) {
          list.get(i).display();
        }
        return i;
      }
    }
    throw new NoSuchElementException("The phone number not exist!");
  }

  /**
   * Delete a phone number by index.
   *
   * @param index The position user want to delete a phone number.
   */
  public void deleteByIndex(int index) {
    System.out.println("Here is phone number info you want to delete!");
    list.get(index).display();
    
    if(Helper.isContinue()) {
      list.remove(index);
      System.out.println("Succesful!");
    } else {
      System.out.println("Canceled!");
    }
  }

  /**
   * Delete a phone number by phone number.
   *
   * @param phoneNumber Phone number need to delete.
   */
  public void deleteByPhoneNumber(String phoneNumber) {
    int index = searchPhoneNumber(phoneNumber);
    System.out.println("Here is phone number info you want to delete!");
    list.get(index).display();

    if(Helper.isContinue()) {
      list.remove(index);
      System.out.println("Succesful!");
    } else {
      System.out.println("Canceled!");
    }
  }

  public void display() {
    System.out.println("============ Phone Book ============");
    System.out.printf("%-19s|%15s\n", "Name", "Phone number");
    list.forEach(phone -> {
      phone.display();
    });
  }
}
