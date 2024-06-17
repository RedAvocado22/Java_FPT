/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processtest1;

import data.Animal;
import data.Cat;
import data.MyCat;

/**
 *
 * @author FPT Shop
 */
public class ProcessTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ////     Question 1:     /////////////////
        System.out.println("Question 1: ");
        Animal a1 = new Animal("Cat1", 6);
        System.out.println(a1);
        
        Animal a2 = new Animal();
        a2.setName("");
        a2.setAge(-9);
        System.out.println(a2);
        
        a2.setName("Cat2");
        a2.setAge(9);
        System.out.println("ANIMAL[ "+a2.getName() + " - " + a2.getAge() +" ]");
        
        
        ////    Question 2:    ///////////////////
        System.out.println("\nQuestion 2: ");
        Cat ca1 = new Cat("Cat3", 12, "BlackCat");
        System.out.println(ca1);
        ca1.display();        
        
        Cat ca2 = new Cat();
        ca2.accept();
        ca2.display();

        ////     Question 3:     /////////////////
        System.out.println("\nQuestion 3: ");
        Cat c[] = {new Cat("B1A",9,"X"), new Cat("B2A",1,"Y"),
                   new Cat("A1B",8,"Z"), new Cat("A",2,"X"),
                   new Cat("A2B",7,"Z"), new Cat("B3A",6,"Y"),
                   new Cat("B",5,"X") }; 
        Cat ct[] = c.clone();
        MyCat mycat = new MyCat();
        
        // Q3.1
        int number = mycat.countBxxA(c);
        System.out.println("Count = " + number);
        
        // Q3.2
        System.out.println("\nBefore reverse5: ");
        for(Cat temp : c)   
            System.out.print(temp);
        
        System.out.println();
        mycat.reverse5(c);
        System.out.println("After reverse5 OUTPUT: ");
        for(Cat temp : c)   
            System.out.print(temp);
        
        System.out.println();
        
        // Q3.3
        System.out.println("\nBefore move2nd: ");
        for(Cat temp : ct)   
            System.out.print(temp);
        
        mycat.move2nd(ct);
        System.out.println("\nAfter move2nd OUTPUT: ");
        for(Cat temp : ct)   
            System.out.print(temp);
        
        System.out.println();
    }
    
}
