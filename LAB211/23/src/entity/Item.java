/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import bo.FruitBO;
import constant.IConstant;
import java.util.List;
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

    /**
     * Inputs the details of the item (fruit and quantity) from the user.
     *
     * @param fruitBO The FruitBO object used to select the fruit for the item
     * @return true if the item is added successfully, false if the selected
     * fruit is out of stock
     */
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

    /**
     * Calculates the total amount for this item based on the price of the fruit
     * and the quantity.
     *
     * @return The total amount for this item
     */
    public int getAmount() {
        return this.fruit.getPrice() * this.quantity;
    }

    /**
     * Displays the details of this item, including the fruit name, quantity,
     * and total amount.
     */
    public void display() {
        System.out.printf(
                "\n%-10s%10d%10d",
                this.fruit.getName(),
                this.quantity,
                getAmount()
        );
    }
}
