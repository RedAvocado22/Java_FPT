
package data;

public class Account {

    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return balance;
        } else {
            System.out.println("Amount exceed balance.");
            return balance;
        }
    }

    public int transferTo(Account a, int amount) {
        if (amount <= balance) {
            a.credit(amount);
            balance = debit(amount);
        } else {
            System.out.println("Amount exceed balance.");
        }
        return balance;
    }

    @Override
    public String toString() {
        return String.format("|id: %4s|name: %-15s|balance: %4d|", id, name, balance);
    }

}
