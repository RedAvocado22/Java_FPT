/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.FruitBO;
import bo.OrderBO;
import constant.IConstant;
import mock.Data;
import util.Helper;
import util.Validate;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FruitBO fruitBO = new FruitBO(Data.fruits);
        OrderBO orderBO = new OrderBO(Data.orders);

        do {
            Helper.menu();

            int choice = Validate.getInt("Choice: ",
                    IConstant.RANGE_MES,
                    IConstant.INTEGER_MES,
                    1, 4
            );

            switch (choice) {
                case 1 -> {
                    fruitBO.add();
                }

                case 2 -> {
                    orderBO.display();
                }

                case 3 -> {
                    if (!orderBO.add(fruitBO)) {
                        System.out.println("Fruit is sold out!");
                    }
                }
            }
        } while (true);
    }

}
