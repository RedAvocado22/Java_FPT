/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.Cat;

/**
 *
 * @author FPT Shop
 */
public class MyCat implements ICat {

    public MyCat() {
    }

    @Override
    public int countBxxA(Cat c[]) {
        int count = 0;
        for (Cat c1 : c) {
            char first = c1.getName().charAt(0);
            char last = c1.getName().charAt(c1.getName().length() - 1);
            if(first == 'B')
                if(last == 'A') 
                    count++;
        }
        return count;
    }

    @Override
    public void reverse5(Cat[] c) {
        Cat tmp;
        tmp = c[0];
        c[0] = c[4];
        c[4] = tmp;
        tmp = c[1];
        c[1] = c[3];
        c[3] = tmp;
    }
    
    @Override
    public void move2nd(Cat[] c) {
        int start = indexOldCat(c);
        
        Cat tmp = c[start];
        for (int i = start; i < c.length - 1; i++) {
            c[i] = c[i + 1];
        }
        
        c[c.length - 1] = tmp;
    }
    
    public int indexOldCat(Cat c[]) {
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            int age = c[i].getAge();
            if(age > 5) count++;
            if(count == 2) return i;
        }
        return 0;
    }
}
