/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package mock;

import java.util.ArrayList;
import java.util.List;
import entity.Book;

/**
 *
 * @author Admin
 */
public class Data {
  public static List<Book> listBook = new ArrayList<>();

  static {
    listBook.add(new Book("B05", "The moon", 30, 30000));
    listBook.add(new Book("B02", "The sun", 12, 40000));
    listBook.add(new Book("B01", "The car", 54, 50000));
    listBook.add(new Book("B04", "The cat", 21, 60000));
    listBook.add(new Book("B03", "The dog", 9, 60000));
  }
}
