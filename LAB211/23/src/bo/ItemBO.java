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

    public boolean add(FruitBO fruitBO) {
        do {
            Item item = new Item();

            if (!item.input(fruitBO)) {
                return false;
            }

            int index = items.indexOf(item);

            if (index == -1) {
                items.add(item);
            } else {
                items.get(index).merge(item.getQuantity());
            }
            
        } while (Helper.isContinue());

        return true;
    }

    public void display() {
        for (Item item : items) {
            item.display();
        }
    }

    public int calculateTotal() {
        return items.stream().mapToInt(i -> i.getAmount()).sum();
    }
}
