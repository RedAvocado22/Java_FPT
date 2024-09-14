/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Bill {

    private int total;

    public Bill() {
    }

    public Bill(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    /**
     * Input value of bill.
     */
    public void input() {
        this.total = Validate.getInt(
                "Enter value of bill: ", 
                "It must be positive number!", 
                "It must be an integer!", 
                0, Integer.MAX_VALUE
        );
    }
}
