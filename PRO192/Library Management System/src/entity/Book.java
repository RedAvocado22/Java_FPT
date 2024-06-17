/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import constant.IConstant;
import data.MyList;
import util.Validate;

/**
 *
 * @author Admin
 */
public class Book {

  private String bCode, title;
  private int quantity, lended = 0;
  private double price;

  public Book() {
  }

  public Book(String bCode, String title,
              int quantity, int lended, double price) throws Exception {
    this.bCode = bCode;
    this.title = title;
    if (lended > quantity) {
      System.err.println("Lended greater than Quantity!");
      throw new Exception();
    }
    this.quantity = quantity;
    this.lended = lended;
    this.price = price;
  }

  public String getbCode() {
    return bCode;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getLended() {
    return lended;
  }

  /**
   * Increase the lended book quantity
   */
  public void increaseLended() {
    this.lended++;
  }

  /**
   * get id from input validation
   *
   * @param list the list to loop through to check if id is duplicated or not
   * @return valid id from input
   */
  private String getId(MyList<Book> list) {
    while (true) {
      String code = Validate.getString("Enter book's code: ", "Error book code!",
              IConstant.REGEX_CODE);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getbCode().trim().equalsIgnoreCase(code)) {
          isExist = true;
          break;
        }
      }

      if (isExist) {
        System.out.println("ID is exist, try again");
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
  public void input(MyList<Book> list) {
    this.bCode = getId(list);

    this.title = Validate.getString("Enter book's title: ", "Error title!",
            IConstant.REGEX_TEXT);

    this.quantity = Validate.getInt("Enter book's quantity: ", "Quantity must be positive",
            "Quantity must be an integer", 0, Integer.MAX_VALUE);

    this.lended = Validate.getInt("Enter book's lended: ",
            "Lended must be positive and smaller than quantity!",
            "Lended must be an integer!", 0, quantity);

    this.price = Validate.getDouble("Enter book's price: ", "The price must be positive!",
            "Price must be a double!", 0, Double.MAX_VALUE);
  }

  /**
   * Take book's data from a line
   *
   * @param line data of book in String format
   */
  public void parse(String line) {
    String[] params = line.split("\\|");

    try {
      this.bCode = params[0].replaceAll("[^A-Za-z0-9]", "");
      this.title = params[1].trim();
      this.quantity = Integer.parseInt(params[2].trim().replaceAll("[^0-9]", ""));
      this.price = Double.parseDouble(params[3].trim().replaceAll("[^0-9]", ""));
    } catch (ArrayIndexOutOfBoundsException ex) {
    } finally {
    }
  }

  /**
   * Display a book
   */
  public void display() {
    System.out.printf("|%-5s|%-50s|%10d|%10d|%10.2f|%10.2f|",
            this.bCode, this.title, this.quantity, this.lended,
            this.price, this.price * this.quantity);
  }

  @Override
  public String toString() {
    return this.bCode + " | " + this.title + " | " + this.quantity
            + " | " + this.lended + " | " + this.price
            + " | " + (this.price * this.quantity) + "\n";
  }

}
