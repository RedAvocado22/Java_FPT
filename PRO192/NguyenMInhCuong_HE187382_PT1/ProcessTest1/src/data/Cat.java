/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import util.MyToys;

/**
 *
 * @author FPT Shop
 */
public class Cat extends Animal {
    private String type;

    public Cat() {
    }

    public Cat(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void accept() {
        System.out.println("Please input a CAT:");
        super.setName(MyToys.getAString("name"));
        super.setAge(MyToys.getRightInt("age"));
        this.type = MyToys.getAString("type");
    }
    
    public void display() {
        System.out.println("[" + super.getName() + " - " + super.getAge() + " - " + type + "]");
    }
    
    @Override
    public String toString() {
        return "(" + super.getName() + "/" + super.getAge() +"/" + type + ')';
    }
    
    
}
