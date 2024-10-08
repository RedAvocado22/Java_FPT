/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import bo.FruitBO;
import bo.ItemBO;
import constant.IConstant;
import java.util.ArrayList;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Order {

    private String customer;
    private ItemBO itemBO;

    public Order() {
        itemBO = new ItemBO(new ArrayList());
    }

    public Order(String customer, ItemBO itemBO) {
        this.customer = customer;
        this.itemBO = itemBO;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ItemBO getItemBO() {
        return itemBO;
    }

    public void setItemBO(ItemBO itemBO) {
        this.itemBO = itemBO;
    }

    /**
     * Inputs the details of the order (customer and items) from the user.
     *
     * @param fruitBO The FruitBO object used to create items in the order
     * @return true if the order is added successfully, false if no items are
     * added to the order
     */
    public boolean input(FruitBO fruitBO) {
        this.itemBO.add(fruitBO);

        if (itemBO.getItems().isEmpty()) {
            return false;
        }

        this.customer = Validate.getString(
                "Enter name: ",
                IConstant.STRING_MES,
                IConstant.REGEX_NAME
        );

        return true;
    }

    /**
     * Displays the details of the order, including the customer name and total
     * amount.
     */
    public void display() {
        System.out.print("\nCustomer: " + this.customer);

        itemBO.display();

        System.out.println("\nTotal: " + this.itemBO.calculateTotal());
    }
}
