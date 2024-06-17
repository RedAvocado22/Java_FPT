/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author FPT Shop
 */
public class UserInformation {
    private int yob;
    private String address;
    private String name;
    
    public void inputUser(String address, int yob, Account a) {
        this.address = address;
        this.yob = yob;
        this.name = a.getName();
    }
    
    
}