/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import constant.IConstant;
import entity.Fruit;
import entity.Item;
import java.util.List;
import util.Helper;
import util.Validate;

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

    /**
     * Adds an item to the list.Prompts the user for item details and adds it
 to the list.
     *
     * @param fruitBO The FruitBO object used to select fruits for the item
     * return false if user choose the fruit that out of stock.
     * @return 
     */
    public boolean add(FruitBO fruitBO) {
        do {
            Item item = new Item();

            fruitBO.display();

            List<Fruit> fruits = fruitBO.getFruits();
            int len = fruits.size();

            int choice = Validate.getInt("Item: ",
                    IConstant.RANGE_MES,
                    IConstant.INTEGER_MES,
                    1, len
            );
            
            if (!item.input(fruits.get(choice - 1))) {
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

    /**
     * Displays all items in the list, including the fruit name, quantity, and
     * total amount for each item.
     */
    public void display() {
        for (Item item : items) {
            item.display();
        }
    }

    /**
     * Calculates the total cost of all items in the list.
     *
     * @return The total cost of all items
     */
    public int calculateTotal() {
        return items.stream().mapToInt(i -> i.getAmount()).sum();
    }
}
