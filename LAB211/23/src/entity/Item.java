/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import bo.FruitBO;
import constant.IConstant;
import java.util.List;
import java.util.Objects;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Item {

    private Fruit fruit;
    private int quantity;

    public Item() {
    }

    public Item(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void merge(int amount) {
        this.quantity += amount;
    }

    public boolean input(FruitBO fruitBO) {
        fruitBO.display();
        
        List<Fruit> fruits = fruitBO.getFruits();
        int len = fruits.size();

        int choice = Validate.getInt("Item: ",
                IConstant.RANGE_MES,
                IConstant.INTEGER_MES,
                1, len
        );

        this.fruit = fruits.get(choice - 1);

        int stock = this.fruit.getStock();

        if (stock == 0) {
            return false;
        }

        this.quantity = Validate.getInt("Quantity: ",
                IConstant.RANGE_MES,
                IConstant.INTEGER_MES,
                1, stock
        );

        this.fruit.setStock(stock - this.quantity);

        return true;
    }

    public int getAmount() {
        return this.fruit.getPrice() * this.quantity;
    }

    public void display() {
        System.out.printf(
                "\n%-10s%10d%10d",
                this.fruit.getName(),
                this.quantity,
                getAmount()
        );
    }
}
