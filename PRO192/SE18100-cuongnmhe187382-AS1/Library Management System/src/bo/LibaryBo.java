/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import data.MyList;
import entity.Book;
import constant.IConstant;
import entity.Lending;
import entity.Reader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Helper;
import util.Validate;

/**
 *
 * @author Admin
 */
public class LibaryBo {

  private MyList<Book> bookList = new MyList<>();
  private MyList<Reader> readerList = new MyList<>();
  private MyList<Lending> lendingList = new MyList<>();

  public LibaryBo() {
  }

  //============================= Book ========================================
  /**
   * Size of book list
   *
   * @return size of book list
   */
  public int bookListSize() {
    return bookList.size();
  }

  /**
   * Add a book in first position
   *
   * @throws Exception when 'lended' greater than 'quantity'
   */
  public void addBookFirst() throws Exception {
    Book book = new Book();
    book.input(bookList);
    bookList.addFirst(book);
    System.out.println("Succesful!");
  }

  /**
   * Add a book in last position
   *
   * @throws Exception when 'lended' greater than 'quantity'
   */
  public void addBookLast() throws Exception {
    do {
      Book book = new Book();
      book.input(bookList);
      bookList.addLast(book);
    } while (Helper.isContinue());
  }

  /**
   * Add a book after index
   *
   * @param index Positive need to add
   */
  public void addBookIndex(int index) {
    Book book = new Book();
    book.input(bookList);
    bookList.insertAfter(index, book);
    System.out.println("Succesful!");
  }

  /**
   * Display book list
   */
  public void displayBook() {
    if (bookList.isEmpty()) {
      System.out.println("\n Not Found");
    } else {
      System.out.printf("|%-5s|%-50s|%10s|%10s|%10s|%10s|\n",
              "Code", "Title", "Quantity", "Lended", "Price", "Value");
      for (int index = 0; index < bookList.size(); index++) {
        bookList.get(index).display();
        System.out.println("");
      }
    }
  }

  /**
   * Searches for a book with the specified code in the book list.
   *
   * @param code The code of the book to search for.
   * @return The index of the book with the specified code if found, or -1 if
   * not found.
   */
  public int searchBookCode(String code) {
    int index;

    if (bookList.isEmpty()) {
      System.out.println("\n Not Found");
      return -1;
    } else {
      for (index = 0; index < bookList.size(); index++) {
        if (bookList.get(index).getbCode().equalsIgnoreCase(code)) {
          return index;
        }
      }
    }

    return -1;
  }

  /**
   * Prints the details of the book at the specified index in the book list.
   *
   * @param index The index of the book to print details of.
   */
  public void printBook(int index) {
    bookList.get(index).display();
    System.out.println("");
  }

  /**
   * Removes the book at the specified index from the book list.
   *
   * @param index The index of the book to remove.
   * @return true if the book was successfully removed, false otherwise.
   */
  public boolean removeBook(int index) {
    return bookList.removeByIndex(index);
  }

  /**
   * Sorts the book list in ascending order based on the book codes. Uses the
   * Bubble Sort algorithm to perform the sorting.
   */
  public void sortedBookList() { 
    if(bookList.isEmpty()) {
      System.out.println("Not found!");
      return;
    }
    int n = bookList.size();
    boolean swapped;
    do {
      swapped = false;
      for (int i = 1; i < n; i++) {
        if (bookList.get(i - 1).getbCode().compareTo(bookList.get(i).getbCode()) > 0) {
          // Use the index to swap
          Book temp = bookList.get(i - 1);
          bookList.replace(i - 1, bookList.get(i));
          bookList.replace(i, temp);
          swapped = true;
        }
      }
      n--;
    } while (swapped);
    System.out.println("Succesful!");
  }

  /**
   * Read data of books from the file
   */
  public void readFileBook() {
    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader bufferReader = null;

    try {
      String fileName = Validate.getString("Enter file path: ", "Error file path!", IConstant.REGEX_FILE);

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

        bookList.addLast(tmp);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Sussecful!");
  }

  /**
   * Save data of books to file
   */
  public void saveFileBook() {
    FileOutputStream fos = null;

    try {
      String fileName = Validate.getString("Enter file path: ", "Error file path!", IConstant.REGEX_FILE);

      fos = new FileOutputStream(fileName);

      for (int i = 0; i < bookList.size(); i++) {
        String line;
        line = bookList.get(i).toString();
        byte[] b = line.getBytes("utf8");
        fos.write(b);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Succesful!");
  }

  //============================= Reader ======================================
  /**
   * Add a new reader
   *
   * @throws Exception when 'bYear' not valid
   */
  public void addReader() throws Exception {
    do {
      Reader reader = new Reader();
      reader.input(readerList);
      readerList.addLast(reader);
    } while (Helper.isContinue());
  }

  /**
   * Display reader list
   */
  public void displayReader() {
    if (readerList.isEmpty()) {
      System.out.println("\n Not Found");
    } else {
      System.out.printf("|%-5s|%-50s|%10s|\n", "Code", "Name", "Year");
      for (int index = 0; index < readerList.size(); index++) {
        readerList.get(index).display();
        System.out.println("");
      }
    }
  }

  /**
   * Searches for a book with the specified code in the book list.
   *
   * @param code The code of the book to search for.
   * @return The index of the book with the specified code if found, or -1 if
   * not found.
   */
  public int searchReaderCode(String code) {
    int index;

    if (readerList.isEmpty()) {
      System.out.println("\n Not Found");
      return -1;
    } else {
      for (index = 0; index < readerList.size(); index++) {
        if (readerList.get(index).getrCode().equalsIgnoreCase(code)) {
          return index;
        }
      }
    }
    return -1;
  }

  /**
   * Prints the details of the book at the specified index in the reader list.
   *
   * @param index The index of the reader to print details of.
   */
  public void printReader(int index) {
    readerList.get(index).display();
    System.out.println("");
  }

  /**
   * Removes the book at the specified index from the book list.
   *
   * @param index The index of the book to remove.
   * @return true if the book was successfully removed, false otherwise.
   */
  public boolean removeReadere(int index) {
    System.out.println("Succesful!");
    return bookList.removeByIndex(index);
  }

  /**
   * Read reader of books from the file
   */
  public void readFileReader() {
    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader bufferReader = null;

    try {
      String fileName = Validate.getString("Enter file path: ", "Error file path!", IConstant.REGEX_FILE);

      fis = new FileInputStream(fileName);

      reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

      bufferReader = new BufferedReader(reader);

      String line = null;

      while ((line = bufferReader.readLine()) != null) {
        if ((line.isEmpty())) {
          continue;
        }
        Reader std = new Reader();
        std.parse(line);

        readerList.addLast(std);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Sussecful!");
  }

  /**
   * Save data of books to file
   */
  public void saveFileReader() {
    FileOutputStream fos = null;

    try {
      String fileName = Validate.getString("Enter file path: ", "Error file path!", IConstant.REGEX_FILE);

      fos = new FileOutputStream(fileName);
      for (int i = 0; i < readerList.size(); i++) {
        String line;
        line = readerList.get(i).toString();
        byte[] b = line.getBytes("utf8");
        fos.write(b);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException ex) {
          Logger.getLogger(LibaryBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Succesful!");
  }

  //================================= Lending ==================================
  /**
   * Add a new lending
   */
  public void addLending() {
    do {
      Lending lending = new Lending();
      lending.input(bookList, readerList, lendingList);
      if (lending.getbCode() == null || lending.getrCode() == null) {
        System.out.println("An error has occurred. Can not add new lending");
      } else {
        lendingList.addLast(lending);
      }
    } while (Helper.isContinue());
  }

  /**
   * Display all lending
   */
  public void displayLending() {
    if (lendingList.isEmpty()) {
      System.out.println("\n Not Found");
    } else {
      System.out.printf("|%-5s|%-5s|%1s|\n", "bCode", "rCode", "State");
      for (int index = 0; index < lendingList.size(); index++) {
        lendingList.get(index).display();
      }
    }
  }

  /**
   * Sorts the book list in ascending order based on the book codes.Uses the
   * Bubble Sort algorithm to perform the sorting.
   *
   * @param SORT_OPTION choice between sort following bCode or rCode
   */
  public void sortedLending(final String SORT_OPTION) {
    if (lendingList.isEmpty()) {
      System.out.println("Not found!");
      return;
    }
    int n = lendingList.size();
    boolean swapped;

    do {
      swapped = false;
      switch (SORT_OPTION) {
        case IConstant.BCODE_SORT:
          for (int i = 1; i < n; i++) {
            if (lendingList.get(i - 1).getbCode().compareTo(lendingList.get(i).getbCode()) > 0) {
              Lending temp = lendingList.get(i - 1);
              lendingList.replace(i - 1, lendingList.get(i));
              lendingList.replace(i, temp);
              swapped = true;
            }
          }
          n--;
          break;
        case IConstant.RCODE_SORT:
          for (int i = 1; i < n; i++) {
            if (lendingList.get(i - 1).getrCode().compareTo(lendingList.get(i).getrCode()) > 0) {
              Lending temp = lendingList.get(i - 1);
              lendingList.replace(i - 1, lendingList.get(i));
              lendingList.replace(i, temp);
              swapped = true;
            }
          }
          n--;
          break;
      }
    } while (swapped);
    System.out.println("Succesful!");
  }

}
