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
public class Wallet {

    private int balance;

    public Wallet() {
    }

    public Wallet(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Input balance of wallet.
     */
    public void input() {
        this.balance = Validate.getInt(
                "Input value of wallet: ",
                "It must be positive number!",
                "It must be an integer!",
                0, Integer.MAX_VALUE
        );
    }
}
