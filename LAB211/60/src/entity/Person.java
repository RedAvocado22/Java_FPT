/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

/**
 *
 * @author Minh Cuong
 */
public class Person {
    private Wallet wallet;

    public Person() {
        this.wallet = new Wallet();
    }

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
    public void input() {
        this.wallet.input();
    }
    
    public boolean isPayable(int total) {
        return this.wallet.getBalance() >= total;
    }
}
