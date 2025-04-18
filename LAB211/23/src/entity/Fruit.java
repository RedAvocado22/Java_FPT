/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import constant.IConstant;
import java.util.Objects;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Fruit {

    private String id;
    private String name;
    private int price;
    private int stock;
    private String origin;

    public Fruit(String id) {
        this.id = id;
    }

    public Fruit(String id, String name, int price, int stock, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.origin = origin;
    }

    public Fruit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Fruit other = (Fruit) obj;

        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return Objects.equals(this.name, other.name);
    }

    /**
     * Inputs the details of the fruit.
     *
     * @param id the unique id for fruit.
     */
    public void input(String id) {
        this.id = id;

        this.name = Validate.getString(
                "Enter name: ",
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );

        this.price = Validate.getInt("Enter price: ",
                IConstant.RANGE_MES,
                IConstant.INTEGER_MES, 0,
                Integer.MAX_VALUE
        );

        this.stock = Validate.getInt("Enter stock: ",
                IConstant.RANGE_MES,
                IConstant.INTEGER_MES, 0,
                Integer.MAX_VALUE
        );

        this.origin = Validate.getString(
                "Enter origin: ",
                IConstant.STRING_MES,
                IConstant.REGEX_ID
        );
    }

    /**
     * Displays the details of the fruit, including its index in menu. Print
     * "(Sold out)" if the stock is zero.
     *
     * @param index the index number of the fruit for display purposes
     */
    public void display(int index) {
        System.out.printf(
                "%-10d%-10s%-10d%-10d\n",
                index, this.name, this.price, this.stock
        );

        if (this.stock == 0) {
            System.out.print(" (Sold out)");
        }
    }
}
