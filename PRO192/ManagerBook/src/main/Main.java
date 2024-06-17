/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import infor.Book;
import infor.Invoice;
import java.util.List;
import management.Management;
import validate.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Management management = new Management();  // Tạo đối tượng Management

        while (true) {
            System.out.println("Display Menu: \n"
                    + "0. Create default 4 books with their information (invoices optional) \n"
                    + "1. Add / Delete/ Update a book \n"
                    + "2. Search book by name \n"
                    + "3. List all books \n"
                    + "4. List all books after sorting by book name, code, or price based on the user’s request. \n"
                    + "5. Let user to choose some books to buy and compute the total price. \n"
                    + "6. List all invoices or one invoice in detail. \n"
                    + "7. Show the top 3 best seller books, top 3 book in revenue? \n"
                    + "8. Load books & invoices from files (book.txt & invoice.txt) \n"
                    + "9. Automatically update the changes of books and invoices’ information to their files \n"
                    + "10. Quit");
            int choice = Validator.getInt("Enter your choice: ", "Just be 0->10", "Invalid!", 0, 10);
            switch (choice) {
                case 0:
                    management.createDefaultBooks();
                    management.listAllBooks();
                    break;
                case 1:
                    while (true) {
                        int choice2 = Validator.getInt("Do you want to  1.Add, 2.Delete, 3.Update: ", "Just 1->3", "Invalid!", 1, 3);
                        switch (choice2) {
                            case 1:
                                Book newBook = new Book();
                                newBook.input();
                                management.addBook(newBook);
                                break;
                            case 2:
                                String bookCode = Validator.getString("Enter code to delete: ", "Invalid!", "^[A-Z][0-9]{3}$");
                                if (management.getBook(bookCode) == null) {
                                    System.out.println("Can not found code");
                                } else {
                                    management.deleteBook(bookCode);
                                    System.out.println("Deleted!");
                                }
                                break;
                            case 3:
                                bookCode = Validator.getString("Enter code to update: ", "Invalid!", "^[A-Z][0-9]{3}$");
                                Book oldBook = management.getBook(bookCode);
                                if (oldBook == null) {
                                    System.out.println("Can not found code");
                                } else {
                                    String bookName = Validator.getString("Update name: ", "Invalid!", "^.{1,50}$");
                                    double unitPrice = Validator.getDouble("Update price: ", "Must bes >0 and <10000", "Inavlid!", Double.MIN_VALUE, 10000 - 0.0000001);
                                    int quantity = Validator.getInt("Update quantity: ", "Must be > 0", "Invalid!", 1, Integer.MAX_VALUE);
                                    Book nBook = new Book(bookCode, bookName, unitPrice, quantity);
                                    management.updateBook(bookCode, nBook);
                                }
                                break;
                        }
                        String choose = Validator.getString("Continue add (yes/no)?", "Just yes or no", "^yes|no$");
                        if (choose.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    String name = Validator.getString("Enter book name to search:", "Invalid!", "^.{1,50}$");
                    List<Book> foundBooks = management.searchBooksByName(name);
                    if (foundBooks.isEmpty()) {
                        System.out.println("Can  not found");
                    } else {
                        for (int i = 0; i < foundBooks.size(); i++) {
                            System.out.printf("%d. %s, %s, %.0f, %d\n",(i+1),
                                    foundBooks.get(i).getBookCode(),foundBooks.get(i).getBookName(),
                                    foundBooks.get(i).getUnitPrice(),foundBooks.get(i).getQuantity());
                        }
                    }
                    break;
                case 3:
                    management.listAllBooks();
                    break;
                case 4:
                    int sortBy = Validator.getInt("Choose field to sort? 1.code, 2.name, 3.price: ",
                            "Just be 1->3", "Invalid!", 1, 3);
                    management.listBooksSorted(sortBy);
                    management.listAllBooks();
                    break;
                case 5:
                    Invoice x = new Invoice();
                    x.input(management.getBooks());
                    x.display(management.getBooks());
                    management.addInvoice(x);
                    break;
                case 6:
                    management.listAllInvoices();
                    break;
                case 7:
                    management.displayTopSellingBooks();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    return;
            }
        }
    }
   
}
