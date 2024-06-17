/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import constant.IConstant;
import entity.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Validate;

/**
 *
 * @author Admin
 */
public class BookBo {
  private List<Book> list;

  public BookBo() {
  }

  public BookBo(List<Book> list) {
    this.list = list;
  }
  
  /**
   * Add a new book.
   */
  public void add() {
    Book book = new Book();
    book.input(list);
    list.add(book);
    System.out.println("A new book is added!");
  }
  
  /**
   * Display all book.
   */
  public void display() {
    System.out.printf("%-5s|%-20s|%-13s|%-7s\n", "Code", "Title", "Quantity", "Price");
    list.forEach((book) -> {
      book.display();
    });
  }
  
  /**
   * Search book that have that code.
   * 
   * @param code the code of book needed to find.
   * @return index of book.
   */
  public int search(String code) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCode().equalsIgnoreCase(code)) {
        return i;
      }
    }
    
    System.out.println("The book not exist!");
    return -1;
  }
  
  /**
   * Display only one book by the index.
   * 
   * @param index the position of book need to display.
   */
  public void displayOne(int index) {
    list.get(index).display();
  }
  
  /**
   * Update book price.
   * 
   * @param index the position of book need to update price.
   */
  public void updatePrice(int index) {
    int newPrice = Validate.getInt("Enter new price: ", 
                                   "Price is out of range!", 
                                   "Price must be a digit!", 
                                    0, Integer.MAX_VALUE);
    list.get(index).setPrice(newPrice);
  }
  
  /**
   * Find the expensive book.
   * 
   * @return the most expensive book.
   */
  public Book mostExpensive() {
    return Collections.max(list, Comparator.comparing(Book::getPrice));
  }
  
  /**
   * Sort the book list.
   */
  public void sort() {
    Collections.sort(list);
  }
  
  /**
   * Remove by index.
   * 
   * @param index the position of book need to remove.
   */
  public void remove(int index) {
    list.remove(index);
  }
  
  /**
   * Read data of books from the file.
   */
  public void takeData() {
    list.removeAll(list);
    
    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader bufferReader = null;

    try {
      String fileName = Validate.getString("Enter file path: ", 
                                           "Error file path!", 
                                           IConstant.REGEX_FILE);
      
      File file = new File(fileName);
      
      if (!file.exists()) {
        System.out.println("File not exist!");
        return;
      }

      fis = new FileInputStream(fileName);
      
      reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

      bufferReader = new BufferedReader(reader);

      String line = null;

      while ((line = bufferReader.readLine()) != null) {
        if ((line.isEmpty())) {
          continue;
        }

        Book tmp = new Book();
        tmp.parse(line);

        list.add(tmp);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(BookBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(BookBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(BookBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(BookBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(BookBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Sussecful!");
  }
}
