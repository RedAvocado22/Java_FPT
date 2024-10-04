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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.fruit);
        hash = 97 * hash + this.quantity;
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
        final Item other = (Item) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        return Objects.equals(this.fruit, other.fruit);
    }
    
    public void merge(int amount) {
        this.quantity += amount;
    }
    
    public void input(FruitBO fruitBO) {
        fruitBO.display();
        List<Fruit> fruits = fruitBO.getFruits();
        int len = fruits.size();
        
        int choice = Validate.getInt(
                "Item: ", 
                IConstant.POSITIVE_MES, 
                IConstant.INTEGER_MES, 
                1, len
        );
        
        this.fruit = fruits.get(choice - 1);
        
        int stock = this.fruit.getStock();
        
        if (stock == 0) {
            return;
        }
        
        this.quantity = Validate.getInt(
                "Quantity: ", 
                IConstant.POSITIVE_MES, 
                IConstant.INTEGER_MES, 
                1, stock
        );
        
        this.fruit.setStock(stock - this.quantity);
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
