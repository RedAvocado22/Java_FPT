/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import entity.Order;
import java.util.List;

/**
 *
 * @author Minh Cuong
 */
public class OrderBO {

    private List<Order> orders;

    public OrderBO() {
    }

    public OrderBO(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Adds an order to the list.
     *
     * @param fruitBO The FruitBO object used to create items in the order
     * @return true if the order is added successfully, false if the order
     * cannot be added
     */
    public boolean add(FruitBO fruitBO) {
        Order order = new Order();

        if (order.input(fruitBO)) {
            this.orders.add(order);
            return true;
        }

        return false;
    }

    /**
     * Displays all orders, including the customer name, and the total for each
     * order.
     */
    public void display() {
        this.orders.stream().forEach((order) -> {
            order.display();
        });
    }
}
