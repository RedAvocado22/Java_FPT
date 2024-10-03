/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.BillBO;
import entity.Person;
import java.util.ArrayList;
import util.Helper;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BillBO billBo = new BillBO(new ArrayList<>());
        
        Helper.menu();

        billBo.input();

        Person p = new Person();
        p.input();

        int total = billBo.calculateTotal();

        System.out.println("Total: " + total);
        if (p.isPayable(total)) {
            System.out.println("Enough!");
        } else {
            System.out.println("Not enough!");
        }
    }

}
