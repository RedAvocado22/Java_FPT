package mock;

import bo.ItemBO;
import entity.Fruit;
import entity.Item;
import entity.Order;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Fruit> fruits = new ArrayList() {
        {
            add(new Fruit("1", "Coconut", 100, 10, "vn"));
            add(new Fruit("2", "Orange", 200, 10, "us"));
            add(new Fruit("3", "Apple", 100, 20, "tl"));
            add(new Fruit("4", "Mango", 100, 30, "vn"));
        }
    };

    public static List<Item> items = new ArrayList() {
        {
            add(new Item(fruits.get(0), 20));
            add(new Item(fruits.get(1), 50));
            add(new Item(fruits.get(2), 30));
        }
    };

    public static List<Order> orders = new ArrayList() {
        {
            add(new Order("Cuong", new ItemBO(items)));
        }
    };
}
