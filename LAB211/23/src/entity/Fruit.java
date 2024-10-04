/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import constant.IConstant;
import java.util.List;
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
        hash = 89 * hash + this.price;
        hash = 89 * hash + this.stock;
        hash = 89 * hash + Objects.hashCode(this.origin);
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
        return true;
    }

    private String getId(List<Fruit> fruits) {
        do {
            String id = Validate.getString(
                    "Enter id: ",
                    IConstant.STRING_MES,
                    IConstant.REGEX_NAME
            );
            
            boolean isExist = fruits.stream().anyMatch(f -> f.getId().equals(id));
            
            if (isExist) {
                System.out.println("The id is exist!");
            } else {
                return id;
            }
        } while (true);
    }

    public void input(List<Fruit> fruits) {
        this.id = getId(fruits);

        this.name = Validate.getString(
                "Enter name: ",
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );

        this.price = Validate.getInt(
                "Enter price: ",
                IConstant.POSITIVE_MES,
                IConstant.INTEGER_MES, 0,
                Integer.MAX_VALUE
        );

        this.stock = Validate.getInt(
                "Enter stock: ",
                IConstant.POSITIVE_MES,
                IConstant.INTEGER_MES, 0,
                Integer.MAX_VALUE
        );

        this.origin = Validate.getString(
                "Enter origin: ",
                IConstant.STRING_MES,
                IConstant.REGEX_ID
        );
    }

    public void display(int index) {
        System.out.printf(
                "\n%10d|%10s|%10d|%10d",
                index, this.name, this.price, this.stock
        );

        if (this.stock == 0) {
            System.out.println(" (Sold out)");
        }
    }
}
