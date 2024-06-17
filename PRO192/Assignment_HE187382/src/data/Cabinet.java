/**
 * Assignment - Book Store
 * Class ID     : SE18100
 * Student ID   : HE187382
 * Student name : Nguyễn Minh Cường
 * Due date     : 19 March 2024
 * I declare that this assignment is my own work in accordance with FPT Policy
 */
package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Menu;
import util.MyToys;

public class Cabinet {

  private final ArrayList<Book> bookList = new ArrayList();
  private final ArrayList<Invoice> invoiceList = new ArrayList();
  private final ArrayList<SoldBook> soldBook = new ArrayList();

  private final Scanner sc = new Scanner(System.in);

  public void addNew(String book_code, String book_name, double unit_price, int quantity) {
    soldBook.add(new SoldBook(book_code));
    bookList.add(new Book(book_code, book_name, unit_price, quantity));
    saveFile_Book();
  }

  public void addNewBook() {
    String id, name;
    double unit_price;
    int quantity;
    int pos;

    do {
      id = MyToys.getID("Input book code(AXXX): ",
              "The format of id is AXXXX (A stands for a uppercase - X stands for a digit)", "^[A-Z ]\\d{3}$");
      pos = searchBookCode(id);
      if (pos >= 0) {
        System.out.println("The book code already exists. "
                + "Try another one!");
      }
    } while (pos != -1);
    soldBook.add(new SoldBook(id));
    name = MyToys.getString("Input book name: ", "The book name is required! (No more than 50 words)");
    unit_price = MyToys.getADouble("Input unit price: ", "Unit price must be  positive and less than $10 000", 0,
            10000);
    quantity = MyToys.getPositiveInt();
    bookList.add(new Book(id, name, unit_price, quantity));
    System.out.println("A book is added sucessfully");
    saveFile_Book();
  }

  public void searchBookByName() {
    int count = 0;
    String book_name;
    if (bookList.isEmpty()) {
      return;
    }
    book_name = MyToys.getString("Enter book name to search: ",
            "The book name is required! (No more than 50 words)");

    for (int i = 0; i < bookList.size(); i++) {
      if (bookList.get(i).getBook_name().contains(book_name)) {
        count++;
      }
    }
    if (count > 1) {
      System.out.println("Found " + count + "books: ");
    } else {
      System.out.println("Found 1 book: ");
    }
    for (int i = 0; i < bookList.size(); i++) {
      if (bookList.get(i).getBook_name().contains(book_name)) {
        System.out.println(bookList.get(i).toString());
      }
    }
  }

  private int searchBookCode(String bookID) {
    int pos;
    if (bookList.isEmpty()) {
      return -1;
    }

    for (int i = 0; i < bookList.size(); i++) {
      if (bookList.get(i).getBook_code().equalsIgnoreCase(bookID)) {
        return i;
      }
    }

    return -1;
  }

  public Book searchBookObjectByID(String BookID) {
    if (bookList.isEmpty()) {
      return null;
    }
    for (int i = 0; i < bookList.size(); i++) {
      if (bookList.get(i).getBook_code().equalsIgnoreCase(BookID)) {
        return bookList.get(i);
      }
    }
    return null;
  }

  public void updateBook() {
    String id;
    String tmpName, tmpCode;
    double tmpPrice;
    int tmpQuantity;
    Book x;
    int pos;
    id = MyToys.getString("Input book code: ", "Book code is required!");
    x = searchBookObjectByID(id);
    System.out.println("------------------------------------");
    if (x == null) {
      System.out.println("Not found!!!");
    } else {
      System.out.println("Here is the book before updating");
      System.out.println(x.toString());
      int choice;
      Menu menu_cnpq = new Menu("Change information");
      menu_cnpq.addNewOption("1. Book code");
      menu_cnpq.addNewOption("2. Book name");
      menu_cnpq.addNewOption("3. Unit price");
      menu_cnpq.addNewOption("4. Quantity");
      menu_cnpq.printMenu();
      choice = menu_cnpq.getChoice();
      switch (choice) {
        case 1:
          do {
            tmpCode = MyToys.getID("Input book code(AXXX): ",
                    "The format of id is AXXXX (A stands for a uppercase - X stands for a digit)",
                    "^[A-Z ]\\d{3}$");
            x.setBook_code(tmpCode);
            pos = searchBookCode(id);
            if (pos >= 0) {
              System.out.println("The book code already exists. "
                      + "Try another one!");
            }
          } while (pos != -1);
          break;
        case 2:
          tmpName = MyToys.getString("Input new name: ", "Name is required! (No more than 50 words)");
          x.setBook_name(tmpName);
          break;
        case 3:
          tmpPrice = MyToys.getADouble("Input unit price: ",
                  "Unit price must be  positive and less than $10 000", 0, 10000);
          x.setUnit_price(tmpPrice);
          break;
        case 4:
          tmpQuantity = MyToys.getPositiveInt();
          x.setQuantity(tmpQuantity);
          break;
      }

      System.out.println("The Book info is updated successfully!");
    }
    saveFile_Book();
  }

  public void removeBook() {
    String id;
    int pos;
    id = MyToys.getString("Input book code: ", "Book code is required!");
    pos = searchBookCode(id);
    if (pos == -1) {
      System.out.println("Not found!!!");
    } else {
      System.out.println("Are you sure???");
      String choice = MyToys.getString("Enter Yes or No: ", "Please try again!");
      if (choice.equalsIgnoreCase("yes")) {
        bookList.remove(pos);
        soldBook.remove(pos);
        System.out.println("The selected book is removed successfully!");
      } else {
        System.out.println("Canceled activity");
      }
    }
    saveFile_Book();
  }

  public void printBookList() {
    if (bookList.isEmpty()) {
      System.out.println("The cage is empty. Nothing to print!");
      return;
    }
    String header = String.format("|%-6s|%-50s|%10s|%10s|", "Code", "Name", "Price", "Quantity");
    System.out.println("------------------------------------");
    System.out.println("Here is the book list");
    System.out.println(header);
    for (int i = 0; i < bookList.size(); i++) {
      bookList.get(i).showProfile();
    }
  }

  public void printBookListAscendingByCode() {
    if (bookList.isEmpty()) {
      System.out.println("The cage is empty. Nothing to print!");
      return;
    }
    Collections.sort(bookList);
    String header = String.format("|%-6s|%-50s|%10s|%10s|", "Code", "Name", "Price", "Quantity");
    System.out.println("------------------------------------");
    System.out.println("Here is the book list");
    System.out.println(header);
    for (int i = 0; i < bookList.size(); i++) {
      bookList.get(i).showProfile();
    }
  }

  public void printBookListAscendingByName() {
    if (bookList.isEmpty()) {
      System.out.println("The cage is empty. Nothing to print!");
      return;
    }
    Comparator nameBalance = (Comparator<Book>) (Book o1, Book o2) -> o1.getBook_name()
            .compareToIgnoreCase(o2.getBook_name());
    Collections.sort(bookList, nameBalance);
    String header = String.format("|%-6s|%-50s|%10s|%10s|", "Code", "Name", "Price", "Quantity");
    System.out.println("------------------------------------");
    System.out.println("Here is the book list");
    System.out.println(header);
    for (int i = 0; i < bookList.size(); i++) {
      bookList.get(i).showProfile();
    }
  }

  public void printBookListAscendingByPrice() {
    if (bookList.isEmpty()) {
      System.out.println("The cage is empty. Nothing to print!");
      return;
    }
    Comparator priceBalance = (Comparator<Book>) (Book o1, Book o2) -> {
      if (o1.getUnit_price() >= o2.getUnit_price()) {
        return 1;
      } else {
        return -1;
      }
    };
    Collections.sort(bookList, priceBalance);
    String header = String.format("|%-6s|%-50s|%10s|%10s|", "Code", "Name", "Price", "Quantity");
    System.out.println("------------------------------------");
    System.out.println("Here is the book list");
    System.out.println(header);
    for (int i = 0; i < bookList.size(); i++) {
      bookList.get(i).showProfile();
    }
  }

  public void addNewInvoice() {
    String id;
    id = MyToys.getString("Entry invoice code: ", "Invoice code is needed!");
    ArrayList<String> soldbook = new ArrayList<>();
    ArrayList<Integer> soldQuantity = new ArrayList<>();
    ArrayList<Double> totalpriceEach = new ArrayList<>();

    boolean check = true;
    do {
      String bookCode = MyToys.getString("Enter code to buy: ", "Book's oode is needed!");
      if (searchBookCode(bookCode) > -1 && bookList.get(searchBookCode(bookCode)).getQuantity() > 0) {
        double price = bookList.get(searchBookCode(bookCode)).getUnit_price();
        int quantityAvaiable = bookList.get(searchBookCode(bookCode)).getQuantity();
        soldbook.add(bookCode);
        String msg = String.format("The quantity must be positive and smaller than " + quantityAvaiable);
        int quantity = MyToys.getAnInteger("How many books do you want to buy?  ", msg, 0, quantityAvaiable);
        soldQuantity.add(quantity);
        bookList.get(searchBookCode(bookCode)).setQuantity(quantityAvaiable - quantity);
        totalpriceEach.add(price * quantity);
        soldBook.get(searchBookCode(bookCode)).sold(quantity, price * quantity);
      } else {
        System.out.println("Book's code isnt exist (or out of stock)");
      }

      String choice = MyToys.getString("Continue? (YES or NO) ", "Try again! (YES or NO)");
      check = choice.equalsIgnoreCase("yes");
    } while (check);
    invoiceList.add(new Invoice(id, soldbook, soldQuantity, MyToys.sum(totalpriceEach)));
    String header = String.format("|%-6s|%-10s|%8s|%8s|", "Code", "Quantity", "Price", "Value");
    System.out.println("Your invoice code: " + id);
    System.out.println(header);
    for (int i = 0; i < soldbook.size(); i++) {
      System.out.printf("|%-6s|%-10d|%8.1f|%8.1f|\n", soldbook.get(i), soldQuantity.get(i), totalpriceEach.get(i),
              soldQuantity.get(i) * totalpriceEach.get(i));
    }
    System.out.println("====================================");
    System.out.println("");
    System.out.printf("%37.0f\n", MyToys.sum(totalpriceEach));
    System.out.printf("Vat  %32.0f\n", (MyToys.sum(totalpriceEach) * 0.1));
    System.out.printf("Total%32.0f\n", MyToys.sum(totalpriceEach) + (MyToys.sum(totalpriceEach) * 0.1));
    saveFile_Invoice();
  }

  public void addInvoice() {
    for (int i = 0; i < invoiceList.size(); i++) {
      ArrayList<String> name = invoiceList.get(i).getSoldBook();
      ArrayList<Integer> quantity = invoiceList.get(i).getSoldQuantity();
      for (int j = 0; j < name.size(); j++) {
        if (searchBookCode(name.get(j)) <= -1) {
          System.out.println("Wrong store cause our store doesnt has this book!!!!");
          return;
        } else {
          double price = bookList.get(searchBookCode(name.get(j))).getUnit_price();

          bookList.get(searchBookCode(name.get(j)))
                  .setQuantity(bookList.get(searchBookCode(name.get(j))).getQuantity() - quantity.get(j));

          soldBook.get(searchBookCode(name.get(j))).sold(quantity.get(j), (quantity.get(j) * price));
        }
      }
    }
  }

  public void listAllInvoice() {
    System.out.println("Invoice code will has form like |Book's code, Quantity| and Total Value\n");
    for (int i = 0; i < invoiceList.size(); i++) {
      invoiceList.get(i).showProfile();
    }
  }

  public void printsoldBookList() {
    addInvoice();
    if (bookList.isEmpty()) {
      System.out.println("Store is empty!");
      return;
    }
    String header = String.format("|%-6s|%-10s|%10s|", "No", "Code", "Quantity");
    System.out.println("------------------------------------");
    System.out.println("Here is top 3 best seller (quantity)");
    System.out.println(header);
    Comparator quantitySold = (Comparator<SoldBook>) (SoldBook o1, SoldBook o2) -> {
      if (o1.getQuantity() >= o2.getQuantity()) {
        return -1;
      } else {
        return 1;
      }
    };
    Collections.sort(soldBook, quantitySold);
    for (int i = 0; i < 3; i++) {
      System.out.printf("|%-6s|%-10s|%10d|\n", i + 1, soldBook.get(i).getBook_code(),
              soldBook.get(i).getQuantity());
    }
    header = String.format("|%-6s|%-10s|%10s|%10s|%15s|", "No", "Code", "Quantity", "Price", "Total Revenue");
    System.out.println("------------------------------------");
    System.out.println("Here is top 3 best seller (revenue)");
    System.out.println(header);
    Comparator quantityRevuene = (Comparator<SoldBook>) (SoldBook o1, SoldBook o2) -> {
      if (o1.getRevenue() >= o2.getRevenue()) {
        return -1;
      } else {
        return 1;
      }
    };
    Collections.sort(soldBook, quantityRevuene);
    for (int i = 0; i < 3; i++) {
      System.out.printf("|%-6d|%-10s|%10d|%10.0f|%15.0f|\n", i + 1, soldBook.get(i).getBook_code(),
              soldBook.get(i).getQuantity(),
              bookList.get(searchBookCode(soldBook.get(i).getBook_code())).getUnit_price(),
              soldBook.get(i).getRevenue());
    }
  }

  public void print2thLowestPrice() {
    if (bookList.isEmpty()) {
      System.out.println("The cage is empty. Nothing to print!");
      return;
    }
    Comparator priceBalance = (Comparator<Book>) (Book o1, Book o2) -> {
      if (o1.getUnit_price() >= o2.getUnit_price()) {
        return 1;
      } else {
        return -1;
      }
    };
    Collections.sort(bookList, priceBalance);
    String header = String.format("|%-6s|%-50s|%10s|%10s|", "Code", "Name", "Price", "Quantity");
    System.out.println("------------------------------------");
    System.out.println("Here is the 2th lowest price book");
    System.out.println(header);
    bookList.get(bookList.size() - 1).showProfile();

  }

  public void printAllSoldBook() {
    addInvoice();
    for (int i = 0; i < soldBook.size(); i++) {
      int tmp = soldBook.get(i).getQuantity();
      if (tmp > 0) {
        System.out.println(soldBook.get(i).getBook_code());
      }
    }
  }

  private void saveFile_Book() {
    FileOutputStream fos = null;

    try {
      fos = new FileOutputStream("BookStore_Output.txt");
      for (Book book : bookList) {
        String line = book.toString();
        byte[] b = line.getBytes("utf8");
        fos.write(b);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  private void saveFile_Invoice() {
    FileOutputStream fos = null;

    try {
      fos = new FileOutputStream("Invoice_Output.txt", true);
      for (Invoice invoice : invoiceList) {
        String line = invoice.toString();
        byte[] b = line.getBytes("utf8");
        fos.write(b);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  public void readFileBook() {
    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader bufferReader = null;

    try {
      fis = new FileInputStream("BookStore_Input.txt");

      reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

      bufferReader = new BufferedReader(reader);

      String line = null;

      while ((line = bufferReader.readLine()) != null) {
        if ((line.isEmpty())) {
          continue;
        }
        Book std = new Book();
        std.parse(line);

        SoldBook tmp = new SoldBook();
        tmp.parse(line);

        soldBook.add(tmp);
        bookList.add(std);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Sussecful!");
  }

  public void readFileInvoice() {
    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader bufferReader = null;

    try {
      fis = new FileInputStream("Invoice_Input.txt");

      reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

      bufferReader = new BufferedReader(reader);

      String line = null;

      while ((line = bufferReader.readLine()) != null) {
        if ((line.isEmpty())) {
          continue;
        }
        Invoice std = new Invoice();
        std.parse(line);

        invoiceList.add(std);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(Cabinet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    System.out.println("Sussecful!");
  }
}
