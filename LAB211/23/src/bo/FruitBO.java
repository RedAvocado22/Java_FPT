/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import constant.IConstant;
import entity.Fruit;
import java.util.ArrayList;
import java.util.List;
import util.Helper;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class FruitBO {

    private List<Fruit> fruits;

    public FruitBO() {
        this.fruits = new ArrayList();
    }

    public FruitBO(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    /**
     * Adds a fruit to the list. Prompts the user for fruit details and adds it
     * to the list.
     */
    public void add() {
        do {
            Fruit f = new Fruit();

            f.input(generateId());

            fruits.add(f);
        } while (Helper.isContinue());
    }

    /**
     * Displays all the fruits in the list, including their details such as
     * name, price, and stock.
     */
    public void display() {
        for (int i = 0; i < fruits.size(); i++) {
            fruits.get(i).display(i + 1);
        }
    }
    
    /**
     * Retrieves a unique ID for the fruit from the user. Ensures that the ID
     * does not already exist in the provided list of fruits.
     *
     * @param fruits The list of existing fruits to check for duplicate IDs
     * @return A unique ID entered by the user
     */
    private String generateId() {
        do {
            String id = Validate.getString(
                    "Enter id: ",
                    IConstant.STRING_MES,
                    IConstant.REGEX_ID
            );

            boolean isExist = this.fruits.stream()
                                         .anyMatch(f -> f.getId().equals(id));

            if (isExist) {
                System.out.println("The id is exist!");
            } else {
                return id;
            }
        } while (true);
    }
}
