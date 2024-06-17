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
public class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if(MyToys.isStringEmpty(name)) name = "NoName";
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 0) age = 0;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", age=" + age + '}';
    }
    
    
}
