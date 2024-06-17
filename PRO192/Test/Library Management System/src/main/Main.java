/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.LibaryBo;
import constant.IConstant;
import util.Helper;
import util.MenuUI;
import util.Validate;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

  public static void main(String[] args) throws Exception {
    int choice, index, choiceIn;
    String code, respond;

    MenuUI bookList = new MenuUI("Book List");
    bookList.addNewOption("1.1  Load data from file");
    bookList.addNewOption("1.2  Input & add to the end");
    bookList.addNewOption("1.3  Display data");
    bookList.addNewOption("1.4  Save book list to file");
    bookList.addNewOption("1.5  Search by bcode");
    bookList.addNewOption("1.6  Delete by bcode");
    bookList.addNewOption("1.7  Sort by bcode");
    bookList.addNewOption("1.8  Input & add to beginning");
    bookList.addNewOption("1.9  Add after position 'index'");
    bookList.addNewOption("1.10 Delete position 'index'");
    bookList.addNewOption("1.11 Exit");

    MenuUI readerList = new MenuUI("Reader List");
    readerList.addNewOption("1.1  Load data from file");
    readerList.addNewOption("1.2  Input & add to the end");
    readerList.addNewOption("1.3  Display data");
    readerList.addNewOption("1.4  Save reader list to file");
    readerList.addNewOption("1.5  Search by rcode");
    readerList.addNewOption("1.6  Delete by rcode");
    readerList.addNewOption("1.7  Exit");

    MenuUI lendingList = new MenuUI("Lending List");
    lendingList.addNewOption("1.1  Input data");
    lendingList.addNewOption("1.2  Display data");
    lendingList.addNewOption("1.3  Sort by bcode");
    lendingList.addNewOption("1.4  Sort by rcode");
    lendingList.addNewOption("1.5  Exit");

    MenuUI menu = new MenuUI("Libary Mangement System");
    menu.addNewOption("1. Book menu");
    menu.addNewOption("2. Reader menu");
    menu.addNewOption("3. Lending menu");
    menu.addNewOption("4. Exit");

    LibaryBo libary = new LibaryBo();

    do {
      menu.printMenu();
      choice = menu.getChoice();
      switch (choice) {
        case 1:
          do {
            bookList.printMenu();
            choiceIn = bookList.getChoice();
            switch (choiceIn) {
              case 1:
                libary.readFileBook();
                break;
              case 2:
                libary.addBookLast();
                break;
              case 3:
                libary.displayBook();
                break;
              case 4:
                libary.saveFileBook();
                break;
              case 5:
                code = Validate.getString("Enter book's code need to find: ",
                        "Error code!", IConstant.REGEX_CODE);
                System.out.println("Here is the book that you need!");
                index = libary.searchBookCode(code);
                if (index >= 0) {
                  libary.printBook(index);
                }
                break;
              case 6:
                code = Validate.getString("Enter book's code need to remove: ",
                        "Error code!", IConstant.REGEX_CODE);
                System.out.println("Here is the book that you want to remove!");
                index = libary.searchBookCode(code);
                if (index >= 0) {
                  libary.printBook(index);
                  if (Helper.isContinue()) {
                    if (libary.removeBook(index)) {
                      System.out.println("Succesful!");
                    }
                  } else {
                    System.out.println("Canceled!");
                  }
                }
                break;
              case 7:
                libary.sortedBookList();
                respond = Validate.getString(
                        "Do you want to print the list out? ",
                        "Only choose Y/N",
                        IConstant.REGEX_YES_NO);
                if (respond.equalsIgnoreCase(IConstant.YES)) {
                  libary.displayBook();
                } else {
                  System.out.println("Alright!");
                }
                break;
              case 8:
                libary.addBookFirst();
                break;
              case 9:
                index = Validate.getInt("Enter index: ", "Not found!",
                        "It must a digit", 0, libary.bookListSize());
                libary.addBookIndex(index);
                break;
              case 10:
                index = Validate.getInt("Enter index: ", "Not found!",
                        "It must a digit", 0, libary.bookListSize());
                libary.printBook(index);
                if (Helper.isContinue()) {
                  if (libary.removeBook(index)) {
                    System.out.println("Succesful!");
                  }
                } else {
                  System.out.println("Canceled!");
                }
                break;
            }
          } while (choiceIn != 11);
          break;
        case 2:
          do {
            readerList.printMenu();
            choiceIn = readerList.getChoice();
            switch (choiceIn) {
              case 1:
                libary.readFileReader();
                break;
              case 2:
                libary.addReader();
                break;
              case 3:
                libary.displayReader();
                break;
              case 4:
                libary.saveFileReader();
                break;
              case 5:
                code = Validate.getString("Enter reader's code need to find: ",
                        "Error code!", IConstant.REGEX_CODE);
                index = libary.searchReaderCode(code);
                System.out.println("Here is the reader that you need!");
                if (index >= 0) {
                  libary.printReader(index);
                }
                break;
              case 6:
                code = Validate.getString("Enter reader's code need to remove: ",
                        "Error code!", IConstant.REGEX_CODE);
                System.out.println("Here is the reader that you want to remove!");
                index = libary.searchReaderCode(code);
                if (index >= 0) {
                  libary.printReader(index);
                  if (Helper.isContinue()) {
                    if (libary.removeReadere(index)) {
                      System.out.println("Succesful!");
                    }
                  } else {
                    System.out.println("Canceled!");
                  }
                }
                break;
            }
          } while (choiceIn != 7);
          break;
        case 3:
          do {
            lendingList.printMenu();
            choiceIn = lendingList.getChoice();
            switch (choiceIn) {
              case 1:
                libary.addLending();
                break;
              case 2:
                libary.displayLending();
                break;
              case 3:
                libary.sortedLending(IConstant.BCODE_SORT);
                respond = Validate.getString(
                        "Do you want to print the list out? ",
                        "Only choose Y/N",
                        IConstant.REGEX_YES_NO);
                if (respond.equalsIgnoreCase(IConstant.YES)) {
                  libary.displayLending();
                } else {
                  System.out.println("Alright!");
                }
                break;
              case 4:
                libary.sortedLending(IConstant.RCODE_SORT);
                respond = Validate.getString(
                        "Do you want to print the list out? ",
                        "Only choose Y/N",
                        IConstant.REGEX_YES_NO);
                if (respond.equalsIgnoreCase(IConstant.YES)) {
                  libary.displayLending();
                } else {
                  System.out.println("Alright!");
                }
                break;
            }
          } while (choiceIn != 5);
          break;
      }
    } while (choice != 4);
    System.out.println("Good bye!");
  }
}
