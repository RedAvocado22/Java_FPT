/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import constant.IConstant;
import java.util.List;
import util.Validate;

/**
 *
 * @author Admin
 */
public class Book implements Comparable<Book> {

  String code, title;
  int quantity;
  double price;

  public Book() {
  }

  public Book(String code, String title, int quantity, double price) {
    this.code = code;
    this.title = title;
    this.quantity = quantity;
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * get id from input validation
   *
   * @param list the list to loop through to check if id is duplicated or not
   * @return valid id from input
   */
  private String getId(List<Book> list) {
    while (true) {
      String code = Validate.getString("Enter book's code: ", 
                                       "Error book code!",
                                       IConstant.REGEX_CODE);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getCode().trim().equalsIgnoreCase(code)) {
          isExist = true;
          break;
        }
      }

      if (isExist) {
        System.out.println("Code is exist, try again");
      } else {
        return code;
      }
    }
  }

  /**
   * Input a book
   *
   * @param list the list to loop through to check if id is duplicated or not
   */
  public void input(List<Book> list) {
    this.code = getId(list);

    this.title = Validate.getString("Enter book's title: ",  
                                    "Error title!",
                                    IConstant.REGEX_TEXT);

    this.quantity = Validate.getInt("Enter book's quantity: ", 
                                    "Quantity must be positive",
                                    "Quantity must be an integer", 
                                    0, Integer.MAX_VALUE);

    this.price = Validate.getDouble("Enter book's price: ", 
                                    "The price must be positive!",
                                    "Price must be a double!", 
                                    0, Double.MAX_VALUE);
  }

  public void display() {
    System.out.printf("%-5s|%-20s|%-13d|%-5.2f\n", code, title, quantity, price);
  }

  /**
   * Take book's data from a line
   *
   * @param line data of book in String format
   */
  public void parse(String line) {
    String[] params = line.split("\\|");

    try {
      this.code = params[0].trim();
      this.title = params[1].trim();
      this.quantity = Integer.parseInt(params[2].trim());
      this.price = Double.parseDouble(params[3].trim());
    } catch (ArrayIndexOutOfBoundsException ex) {
    } finally {
    }
  }

  @Override
  public int compareTo(Book other) {
    return this.code.compareTo(other.code);
  }
}
