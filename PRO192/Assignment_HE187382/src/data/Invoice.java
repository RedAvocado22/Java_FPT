/*
    Assignment - Book Store
    Class ID     : SE18100
    Student ID   : HE187382
    Student name : Nguyễn Minh Cường
    Due date     : 19 March 2024
    I declare that this assignment is my own work in accordance with FPT Policy
 */
package data;

import java.util.ArrayList;

public class Invoice {

    private String invoiceId;
    private ArrayList<String> soldBook = new ArrayList<>();
    private ArrayList<Integer> soldQuantity = new ArrayList<>();
    private final double tax = 0.1;
    private ArrayList<Double> totalpriceEach;
    private double totalprice;

    public Invoice(String invoiceId, ArrayList<String> soldBook, ArrayList<Integer> soldQuantity, double totalprice) {
        this.invoiceId = invoiceId;
        this.soldBook = soldBook;
        this.soldQuantity = soldQuantity;
        this.totalprice = totalprice;
    }

    public Invoice() {
    }

    public ArrayList<String> getSoldBook() {
        return soldBook;
    }

    public ArrayList<Integer> getSoldQuantity() {
        return soldQuantity;
    }

    public void parse(String line) {
        String[] params = line.split(",");

        try {
            this.invoiceId = params[0];
            String[] parts = params[1].split("\\|\\|?");

            for (String part : parts) {
                String[] keyValue = part.trim().split(" - ");
                if (keyValue.length == 2) {
                    if (searchBook(keyValue[0].trim()) > -1) {
                        int x = Integer.valueOf(keyValue[1]);
                        int y = soldQuantity.get(searchBook(keyValue[0].trim()));
                        soldQuantity.set(searchBook(keyValue[0].trim()), x + y);
                    } else {
                        soldBook.add(keyValue[0].trim());
                        soldQuantity.add(Integer.valueOf(keyValue[1]));
                    }
                }
            }
            this.totalprice = Double.valueOf(params[2]);
        } catch (ArrayIndexOutOfBoundsException ex) {
        } finally {
        }
    }

    public int searchBook(String s) {
        int pos = -1;
        if (soldBook.isEmpty()) {
            return pos;
        }
        for (int i = 0; i < soldBook.size(); i++) {
            if (soldBook.get(i).equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < soldBook.size(); i++) {
            if (!soldBook.get(i).isEmpty()) {
                result.append("| ");
                result.append(soldBook.get(i));
                result.append(" - ");
                result.append(soldQuantity.get(i));
                result.append(" |");
            }
        }
        return String.format(invoiceId + ", " + result.toString().trim() + ", " + (totalprice + totalprice * tax) + "\n");
    }

    public void showProfile() {
        System.out.printf("%-5s", invoiceId);

        if (soldBook.size() > 0) {
            for (int i = 0; i < soldBook.size() - 1; i++) {
                System.out.print("|" + soldBook.get(i) + " - " + soldQuantity.get(i) + "|");
            }
            System.out.print("|" + soldBook.get(soldBook.size() - 1) + " - " + soldQuantity.get(soldBook.size() - 1) + "| ");
        } else {
            System.out.print("|" + soldBook.get(0) + " - " + soldQuantity.get(0) + "| ");
        }

        System.out.println("$" + (totalprice + totalprice * tax));
        System.out.println("");
    }
}
