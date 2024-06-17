/*
    Assignment - Book Store
    Class ID     : SE18100
    Student ID   : HE187382
    Student name : Nguyễn Minh Cường
    Due date     : 19 March 2024
    I declare that this assignment is my own work in accordance with FPT Policy
 */
package data;

public class Book implements Comparable<Book> {

    private String book_code;
    private String book_name;
    private double unit_price;
    private int quantity;

    public Book() {
    }

    public Book(String book_code, String book_name, double unit_price, int quantity) {
        this.book_code = book_code;
        this.book_name = book_name;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public String getBook_code() {
        return book_code;
    }

    public String getBook_name() {
        return book_name;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void showProfile() {
        System.out.printf("|%-6s|%-50s|%10.1f|%10d| \n", book_code, book_name, unit_price, quantity);
    }

    public void parse(String line) {
        String[] params = line.split(", ");

        try {
            this.book_code = params[0];
            this.book_name = params[1];
            this.unit_price = Double.valueOf(params[2]);
            this.quantity = Integer.valueOf(params[3]);
        } catch (ArrayIndexOutOfBoundsException ex) {
        } finally {
        }
    }

    @Override
    public String toString() {
        return String.format(book_code + ", " + book_name + ", " + unit_price + ", " + quantity + "\n");
    }

    @Override
    public int compareTo(Book that) {
        return this.book_code.compareToIgnoreCase(that.book_code);
    }
}
