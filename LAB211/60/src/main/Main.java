/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.BillBO;
import entity.Wallet;
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
        do {
            Helper.menu();
            
            billBo.input();
            
            Wallet w = new Wallet();
            w.input();
            
            billBo.display(w);
        } while (Helper.isContinue());
    }

}
