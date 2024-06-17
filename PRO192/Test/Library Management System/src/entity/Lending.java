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
public class Lending {

  private String bCode, rCode;
  private int state;

  public Lending() {
  }

  public String getbCode() {
    return bCode;
  }

  public String getrCode() {
    return rCode;
  }

  public int getState() {
    return state;
  }

  public void input(MyList<Book> bookList, MyList<Reader> readerList, MyList<Lending> lendingList) {
    String book = Validate.getString("Enter book's code: ", "Error book code!",
            IConstant.REGEX_CODE);

    String reader = Validate.getString("Enter reader's code: ", "Error reader code!",
            IConstant.REGEX_CODE);

    if (getBCode(bookList, book) == -1 || getRCode(readerList, reader) == -1) {
      System.out.println("Error!");
      return;
    }

    if (checkLendingList(lendingList, book, reader) == -1) {
      System.out.println("Error!");
      return;
    }

    this.rCode = reader;
    int index = getBCode(bookList, book);
    this.bCode = book;
    if (bookList.get(index).getLended() == bookList.get(index).getQuantity()) {
      this.state = 0;
    } else {
      this.state = 1;
      bookList.get(index).increaseLended();
    }
  }

  /**
   * Get bCode is existed in book list.
   *
   * @param list  the list to loop through to check if bCode existed
   * @param bCode the book's code need to check
   * @return exist or not
   */
  private int getBCode(MyList<Book> list, String bCode) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getbCode().trim().equalsIgnoreCase(bCode)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Get rCode is existed in reader list.
   *
   * @param list the list to loop through to check if bCode existed
   * @return exist or not
   */
  private int getRCode(MyList<Reader> list, String rCode) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getrCode().trim().equalsIgnoreCase(rCode)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Get bCode is existed in book list.
   *
   * @param list the list to loop through to check if bCode existed
   * @return exist or not
   */
  private int checkLendingList(MyList<Lending> list, String bCode, String rCode) {
    if (list.isEmpty()) {
      return 1;
    }
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getbCode().trim().equalsIgnoreCase(bCode)
              && list.get(i).getrCode().trim().equalsIgnoreCase(rCode)
              && list.get(i).getState() == 1) {
        return -1;
      }
    }

    return 1;
  }

  public void display() {
    System.out.printf("|%-5s|%-5s|%5d|\n", this.bCode, this.rCode, this.state);
  }
}
