/*
    Assignment - Book Store
    Class ID     : SE18100
    Student ID   : HE187382
    Student name : Nguyễn Minh Cường
    Due date     : 19 March 2024
    I declare that this assignment is my own work in accordance with FPT Policy
 */
package assignment_he187382;

import data.Cabinet;
import ui.Menu;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Assignment_HE187382 {

    public static void main(String[] args) {
        
        Menu menu = new Menu("Book Store");
        menu.addNewOption("1. Create default 4 books with their information");
        menu.addNewOption("2. Add/Delete/Update a book");
        menu.addNewOption("3. Search book by name");
        menu.addNewOption("4. List all books");
        menu.addNewOption("5. List all books after sorting by book name, code, or price based on the user’s request");
        menu.addNewOption("6. Let user to choose some books to buy and compute the total price.");
        menu.addNewOption("7. List all invoices or one invoice in detail");
        menu.addNewOption("8. Show the top 3 best seller books, top 3 book in revenue?");
        menu.addNewOption("9. Load books & invoices from files");
        menu.addNewOption("10. The book has 2th lowest price");
        menu.addNewOption("11. Books has sold atleast 1 book");
        menu.addNewOption("12. Quit");
        
        Cabinet cage = new Cabinet();

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    cage.addNew("C001", "Week 1: Introduction to Java", 100, 20);
                    cage.addNew("D002", "A story of ducks", 30, 10);
                    cage.addNew("A003", "Gonne with the wind", 300, 55);
                    cage.addNew("B004", "Dances with Wolfs", 150, 86);
                    System.out.println("Successful!");
                    break;
                case 2:
                    Menu menu_adu = new Menu("Add/Delete/Update");
                    menu_adu.addNewOption("1. Add a book");
                    menu_adu.addNewOption("2. Update a book (By book code)");
                    menu_adu.addNewOption("3. Delete a book (By book code)");
                    menu_adu.printMenu();
                    choice = menu_adu.getChoice();
                    switch (choice) {
                        case 1:
                            cage.addNewBook();
                            break;
                        case 2:
                            cage.updateBook();
                            break;
                        case 3:
                            cage.removeBook();
                            break;
                    }
                    break;
                case 3:
                    cage.searchBookByName();
                    break;
                case 4:
                    cage.printBookList();
                    break;
                case 5:
                    Menu menu_ncp = new Menu("Sorting by book name, code, or price");
                    menu_ncp.addNewOption("1. By book code");
                    menu_ncp.addNewOption("2. By book name");
                    menu_ncp.addNewOption("3. By book price");
                    menu_ncp.printMenu();
                    choice = menu_ncp.getChoice();
                    switch (choice) {
                        case 1:
                            cage.printBookListAscendingByCode();
                            break;
                        case 2:
                            cage.printBookListAscendingByName();
                            break;
                        case 3:
                            cage.printBookListAscendingByPrice();
                            break;
                    }
                    break;
                case 6:
                    cage.addNewInvoice();
                    break;
                case 7:
                    cage.listAllInvoice();
                    break;
                case 8:
                    cage.printsoldBookList();
                    break;
                case 9:
                    Menu menu_load = new Menu("Load file");
                    menu_load.addNewOption("1. Load book from file");
                    menu_load.addNewOption("2. Load invoice from file");
                    menu_load.printMenu();
                    choice = menu_load.getChoice();
                    switch (choice) {
                        case 1:
                            cage.readFileBook();
                            break;
                        case 2:
                            cage.readFileInvoice();
                            break;
                    }
                    break;
                case 10:
                    cage.print2thLowestPrice();
                    break;
                case 11:
                    cage.printAllSoldBook();
                    break;
                case 12:
                    System.out.println("Good bye, see u soon!");
                    break;
            }
        } while (choice != 12);
    }
}
