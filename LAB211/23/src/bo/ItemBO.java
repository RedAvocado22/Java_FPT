/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import entity.Item;
import java.util.List;
import util.Helper;

/**
 *
 * @author Minh Cuong
 */
public class ItemBO {

    private List<Item> items;

    public ItemBO() {
    }

    public ItemBO(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(FruitBO fruitBO) {
        do {
            Item item = new Item();
            item.input(fruitBO);

            int index = items.indexOf(item);

            if (index == -1) {
                items.add(item);
            } else {
                items.get(index).merge(item.getQuantity());
            }
        } while (Helper.isContinue());
    }
    
    public void display() {
        for (Item item : items) {
            item.display();
        }
    }
    
    public int total() {
        return items.stream().mapToInt(i -> i.getAmount()).sum();
    }
}
