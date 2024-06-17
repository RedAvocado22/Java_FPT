/*
    Assignment - Book Store
    Class ID     : SE18100
    Student ID   : HE187382
    Student name : Nguyễn Minh Cường
    Due date     : 19 March 2024
    I declare that this assignment is my own work in accordance with FPT Policy
 */
package data;

/**
 *
 * @author FPT Shop
 */
public class SoldBook {

    private String book_code;
    private int quantity = 0;
    private double revenue = 0;

    public SoldBook(String book_code) {
        this.book_code = book_code;
    }

    public SoldBook(String book_code, int quantity, double revenue) {
        this.book_code = book_code;
        this.quantity = quantity;
        this.revenue = revenue;
    }
    
    SoldBook() {
    }

    public void sold(int quantity, double revenue) {
        this.quantity += quantity;
        this.revenue += revenue;
    }

    public String getBook_code() {
        return book_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getRevenue() {
        return revenue;
    }

    
    public void parse(String line) {
        String[] params = line.split(", ");

        try {
            this.book_code = params[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
        } finally {
        }
    }

    @Override
    public String toString() {
        return "SoldBook{" + "book_code=" + book_code + ", quantity=" + quantity + ", revenue=" + revenue + '}';
    }
}
