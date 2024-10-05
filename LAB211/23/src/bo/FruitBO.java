/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import entity.Fruit;
import java.util.ArrayList;
import java.util.List;
import util.Helper;

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

    public void add() {
        do {
            Fruit f = new Fruit();

            f.input(fruits);

            fruits.add(f);
        } while (Helper.isContinue());
    }

    public void display() {
        for (int i = 0; i < fruits.size(); i++) {
            fruits.get(i).display(i + 1);
        }
    }
}
