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
public class Reader {

  private String rCode, name;
  private int bYear;

  public Reader() {
  }

  public Reader(String rCode, String name, int bYear) throws Exception {
    this.rCode = rCode;
    this.name = name;
    if (bYear < IConstant.MIN_YEAR || bYear > IConstant.MAX_YEAR) {
      System.err.println("Wrong birth year!");
      throw new Exception();
    }
    this.bYear = bYear;
  }

  public String getrCode() {
    return rCode;
  }

  /**
   * get id from input validation
   *
   * @param list the list to loop through to check if id is duplicated or not
   * @return valid id from input
   */
  private String getId(MyList<Reader> list) {
    while (true) {
      String code = Validate.getString("Enter book's code: ", "Error book code!",
              IConstant.REGEX_CODE);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getrCode().trim().equalsIgnoreCase(code)) {
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
   * Input a reader
   */
  public void input(MyList<Reader> list) {
    this.rCode = getId(list);

    this.name = Validate.getString("Enter reader's name: ", "Error name!",
            IConstant.REGEX_NAME);

    this.bYear = Validate.getInt("Enter reader's birth year: ",
            "Birth year must be from 1900 to 2010!",
            "Birth year must be an integer",
            IConstant.MIN_YEAR, IConstant.MAX_YEAR);
  }

  /**
   * Take reader's data from a line
   *
   * @param line data of reader in String format
   */
  public void parse(String line) {
    String[] params = line.split("\\|");

    try {
      this.rCode = params[0].trim();
      this.name = params[1].trim();
      this.bYear = Integer.parseInt(params[2].trim().replaceAll("[^0-9]", ""));
    } catch (ArrayIndexOutOfBoundsException ex) {
    } finally {
    }
  }

  /**
   * Display a reader
   */
  public void display() {
    System.out.printf("|%-5s|%-50s|%10d|", this.rCode, this.name, this.bYear);
  }

  @Override
  public String toString() {
    return this.rCode + " | " + this.name + " | " + this.bYear + "\n";
  }
}
