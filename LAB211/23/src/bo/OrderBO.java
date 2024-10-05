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

    public boolean add(FruitBO fruitBO) {
        Order order = new Order();

        if (order.input(fruitBO)) {
            this.orders.add(order);
            return true;
        }

        return false;
    }

    public void display() {
        this.orders.stream().forEach((order) -> {
            order.display();
        });
    }
}
