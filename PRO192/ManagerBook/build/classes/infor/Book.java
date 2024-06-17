/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infor;

import validate.Validator;

/**
 *
 * @author win
 */
public class Book {

    private String bookCode; // Must be in the format [A-Z][0-9][0-9][0-9]
    private String bookName; // Up to 50 characters
    private double unitPrice; // Positive and < 10000
    private int quantity;

    // Constructor, getters, setters, and validation methods
    public Book() {
    }

    public Book(String bookCode, String bookName,
            double unitPrice, int quantity) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void input() {
        bookCode = Validator.getString("Enter code: ", "Invalid!", "^[A-Z][0-9]{3}$");
        bookName = Validator.getString("Enter name: ", "Invalid!", "^.{1,50}$");
        unitPrice =Validator.getDouble("Enter price: ", "Must bes >0 and <10000", "Inavlid!", Double.MIN_VALUE, 10000-0.0000001);
        quantity=Validator.getInt("Enter quantity: ", "Must be > 0", "Invalid!", 1, Integer.MAX_VALUE);
    }
}
