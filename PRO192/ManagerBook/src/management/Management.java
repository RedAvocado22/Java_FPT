/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import infor.Book;
import infor.Invoice;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author win
 */
public class Management {

    private List<Book> books = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();


    public List<Book> getBooks() {
        return books;
    }

    // Task 2.0: Create default 4 books
    public void createDefaultBooks() {
        books.add(new Book("C001", "Week 1: Introduction to Java", 100, 20));
        books.add(new Book("D002", "A story of ducks", 30, 10));
        books.add(new Book("A003", "Gone with the wind", 300, 55));
        books.add(new Book("B004", "Dances with Wolves", 150, 86));
    }
    // Task 2.1: Add/Delete/Update a book

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }
    public void addInvoice(Invoice invoice) {
        if (!invoices.contains(invoice)) {
            invoices.add(invoice);
        }
    }
    public Book getBook(String code) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookCode().equalsIgnoreCase(code)) {
                return books.get(i);
            }
        }
        return null;
    }

    public void deleteBook(String bookCode) {
        books.removeIf(book -> book.getBookCode().equals(bookCode));
    }

    public void updateBook(String bookCode, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookCode().equals(bookCode)) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    // Task 2.2: Search book by name
    public List<Book> searchBooksByName(String name) {
        return books.stream()
                .filter(book -> book.getBookName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Task 2.3: List all books
    public void listAllBooks() {
        System.out.format("%-10s %-30s %-10s %-10s%n", "Code", "Name", "Price", "Quantity");
        for (Book book : books) {
            System.out.format("%-10s %-30s %-10.0f %-10d%n", book.getBookCode(), book.getBookName(), book.getUnitPrice(), book.getQuantity());
        }
    }

    // Task 2.4: List all books after sorting by book name, code or price
    public void listBooksSorted(int sortBy) {
        Comparator<Book> comparator;
        switch (sortBy) {
            case 1:
                comparator = Comparator.comparing(Book::getBookCode);
                break;
            case 2:
                comparator = Comparator.comparing(Book::getBookName);
                break;
            case 3:
                comparator = Comparator.comparingDouble(Book::getUnitPrice);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option");
        }
        books.sort(comparator);
    }

    // Task 2.5: Let user choose some books to buy and compute the total price
    public void createInvoice(String invoiceId, Map<String, Integer> bookQuantities) {
        Invoice invoice = new Invoice(invoiceId, bookQuantities);
        invoices.add(invoice);
    }

    // Task 2.6: List all invoices or one invoice in detail
    public  void listAllInvoices() {
        // Header
        System.out.printf("%-10s %-30s %s%n", "InvoiceID", "[Code, quantity]", "Total value");

        // Rows
        for (Invoice invoice : invoices) {
            StringBuilder books = new StringBuilder();
            for (Map.Entry<String, Integer> entry : invoice.getBooksSold().entrySet()) {
                books.append(String.format("[%s, %d] ", entry.getKey(), entry.getValue()));
            }
            System.out.printf("%-10s %-30s $%.0f%n", invoice.getInvoiceId(), books.toString(), invoice.getTotalPrice());
        }
    }

    public void listInvoiceDetails(String invoiceId) {
        invoices.stream()
                .filter(invoice -> invoice.getInvoiceId().equals(invoiceId))
                .findFirst()
                .ifPresent(System.out::println);
    }

    // Task 2.7: Show the top 3 best seller books/top 3 books in revenue
public  void displayTopSellingBooks() {
        Map<String, Integer> bookQuantities = new HashMap<>();
        Map<String, Double> bookRevenues = new HashMap<>();
        
        // Aggregate sales and revenue from all invoices
        for (Invoice invoice : invoices) {
            for (Map.Entry<String, Integer> entry : invoice.getBooksSold().entrySet()) {
                String code = entry.getKey();
                Integer quantity = entry.getValue();
                bookQuantities.put(code, bookQuantities.getOrDefault(code, 0) + quantity);
                
                // Assuming you have a method to get the price of the book by code
                double price = getBook(code).getUnitPrice();
                bookRevenues.put(code, bookRevenues.getOrDefault(code, 0.0) + price * quantity);
            }
        }
        
        // Sort by quantities sold
        List<Map.Entry<String, Integer>> sortedByQuantity = bookQuantities.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(3)
            .collect(Collectors.toList());
        
        // Sort by revenue
        List<Map.Entry<String, Double>> sortedByRevenue = bookRevenues.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(3)
            .collect(Collectors.toList());
        
        // Display the top selling books
        System.out.println("Top 3 best seller book (number of sold books)");
        System.out.println("No\tCode\tQuantity");
        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedByQuantity) {
            System.out.println(rank++ + ".\t" + entry.getKey() + "\t" + entry.getValue());
        }
        
        // Display the top books in revenue
        System.out.println("\nTop 3 books in revenue:");
        System.out.println("No\tCode\tQuantity\tPrice\tTotal revenue");
        rank = 1;
        for (Map.Entry<String, Double> entry : sortedByRevenue) {
            Integer quantity = bookQuantities.get(entry.getKey());
            double price = entry.getValue() / quantity;
            System.out.println(rank++ + ".\t" + entry.getKey() + "\t" + quantity + "\t\t" + price + "\t" + entry.getValue());
        }
    }
}
