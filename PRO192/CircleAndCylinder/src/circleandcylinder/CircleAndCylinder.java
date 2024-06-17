/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleandcylinder;

import data.Cylinder;
import util.MyToys;

//Nguyen Minh Cuong
public class CircleAndCylinder {

    public static void main(String[] args) {
        Cylinder c[] = new Cylinder[100];
        c[0] = new Cylinder(5, 10, "red");
        c[1] = new Cylinder(2, 20, "blue");
        
        int m;
        m = MyToys.getRightInt();
        for (int i = 2; i < m + 2; i++) {
            c[i] = new Cylinder();
            c[i].inputCylinder();
        }

        for (int i = 0; i < m + 2; i++) {
            System.out.println(c[i].toString());
        } 
        
        sortFollowingRad(c, m + 2);
        
        System.out.println("Cylinder after sort: ");
        for (int i = 0; i < m + 2; i++) {
            System.out.println(c[i].toString());
        } 
    }
    
    public static void sortFollowingRad(Cylinder s[], int n){
        Cylinder tmp;    
        for(int i = 0; i < n-1; i++){
            for(int j = i; j < n; j++){
                if(s[i].getRadius() > s[j].getRadius()){
                    tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                }
            }
        }
    }
    
    public static void testMain() {
        Cylinder c1 = new Cylinder();

        System.out.println("Cylinder:"
                + " radius=" + c1.getRadius()
                + " height=" + c1.getHeight()
                + " base area=" + c1.getArea()
                + " volume=" + c1.getVolume());

        Cylinder c2 = new Cylinder(10.0);

        System.out.println("Cylinder:"
                + " radius=" + c2.getRadius()
                + " height=" + c2.getHeight()
                + " base area=" + c2.getArea()
                + " volume=" + c2.getVolume());

        Cylinder c3 = new Cylinder(2.0, 10.0);

        System.out.println("Cylinder:"
                + " radius=" + c3.getRadius()
                + " height=" + c3.getHeight()
                + " base area=" + c3.getArea()
                + " volume=" + c3.getVolume());
        Cylinder c4 = new Cylinder(4, 10, "blue");

        System.out.println(c4);
        System.out.println("Cylinder Area " + c4.getArea());;
        System.out.println("Cylinder Volume: " + c4.getVolume());
    }
}
