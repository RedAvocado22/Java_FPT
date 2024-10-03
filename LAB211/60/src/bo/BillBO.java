/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import entity.Bill;
import java.util.List;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class BillBO {

    private List<Bill> list;

    public BillBO(List<Bill> list) {
        this.list = list;
    }

    public void input() {
        int n = Validate.getInt(
                "Input number of bill: ",
                "It must be a positive number!",
                "It must be an integer!",
                0, Integer.MAX_VALUE
        );

        while (n > 0) {
            Bill bill = new Bill();
            bill.input();
            list.add(bill);
            n--;
        }
    }

    public int calculateTotal() {
        return list.stream().mapToInt(Bill::getTotal).sum();
    }
}
