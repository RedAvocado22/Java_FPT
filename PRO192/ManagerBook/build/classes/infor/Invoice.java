/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import validate.Validator;

/**
 *
 * @author win
 */
public class Invoice {

    private String invoiceId;
    private Map<String, Integer> booksSold; // Map of Book Code to Quantity sold
    private final double TAX = 0.1; // Constant tax value
    private double totalPrice;

    public Invoice() {
    }

    public Invoice(String invoiceId, Map<String, Integer> booksSold, double totalPrice) {
        this.invoiceId = invoiceId;
        this.booksSold = booksSold;
        this.totalPrice = totalPrice;
    }

    public Invoice(String invoiceId, Map<String, Integer> bookQuantities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Map<String, Integer> getBooksSold() {
        return booksSold;
    }

    public void setBooksSold(Map<String, Integer> booksSold) {
        this.booksSold = booksSold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void input(List<Book> listBook) {
        // Initialize the booksSold map to keep track of books being added to this invoice.
        booksSold = new HashMap<>();
        invoiceId = Validator.getString("Enter invoice code: ", "Invalid", "V\\d+");
        int quantity;
        while (true) {
             String  bookCode = Validator.getString("Enter code to buy: ", "Invalid!", "^[A-Z][0-9]{3}$");
            // Validate the book code exists
            boolean x = true;
            for (int i = 0; i < listBook.size(); i++) {
               if(listBook.get(i).getBookCode().equalsIgnoreCase(bookCode)){
                   x=false;
               }
            }
            if(x==true){
                System.out.println("The Book not exist!!Try Again");
                continue;
            }
            quantity = Validator.getInt("Number of book: ", "Must be > 0", "Invalid!", 1, Integer.MAX_VALUE);
            // Add or update the quantity for the book code
            this.booksSold.put(bookCode, booksSold.getOrDefault(bookCode, 0) + quantity);
            String choose = Validator.getString("Continue? (yes/no):", "Just yes or no", "yes|no");
            if (choose.equalsIgnoreCase("no")) {
                break;
            }
        }
        // Calculate the total price based on the selected books and their quantities
        this.totalPrice = booksSold.entrySet().stream()
                .mapToDouble(entry -> {
                    Book book = listBook.stream()
                            .filter(b -> b.getBookCode().equalsIgnoreCase(entry.getKey()))
                            .findFirst()
                            .orElse(null);
                    // Ensure book is not null before getting the price
                    return (book != null ? book.getUnitPrice() * entry.getValue() : 0);
                })
                .sum();

        // Apply tax to the total price
        this.totalPrice *= (1 + TAX);
    }

    public void display(List<Book> listBook) {
        System.out.println("Enter invoice code: "+getInvoiceId());
        System.out.println(String.format("%-5s %-9s %-5s %s", "Code", "Quantity", "Price", "Value"));

        // Initialize total before taxes
        double subtotal = 0;

        for (Map.Entry<String, Integer> entry : booksSold.entrySet()) {
            Book book = listBook.stream()
                    .filter(b -> b.getBookCode().equals(entry.getKey()))
                    .findFirst()
                    .orElse(null);
            if (book != null) {
                double value = entry.getValue() * book.getUnitPrice();
                subtotal += value;
                System.out.println(String.format("%-5s %-9d %-5.2f $%.0f", book.getBookCode(), entry.getValue(), book.getUnitPrice(), value));
            }
        }

        // Calculate and display the total after taxes
        double taxAmount = subtotal * TAX;
        double total = subtotal + taxAmount;

        // Print summary
        System.out.println("=================================");
        System.out.println(String.format("%-19s $%.0f", "        ", subtotal));
        System.out.println(String.format("%-19s $%.0f", "VAT (10%)", taxAmount));
        System.out.println(String.format("%-19s $%.0f", "Total", total));
    }

}
