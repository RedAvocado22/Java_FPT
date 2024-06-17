/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        n = getAPositiveInteger();
        printfIntegerList(n);    //hard-code đầu vào
                                //hok linh hoạt
        //playWithBoolean();
        //playWithCharacters();
        //playWithDoubles();
        //playWithIntegers();
        //playWithVaruables();
    }
    
    //static chỉ chơi với static - OOP
    //1 class bát kì chứa nhiều hàm trùng tên nhưng khác phần tham số
    //hiện tượng class chứa nhiều hàm trùng tên khác datatype gọi là overloađ
    
    public static int getAPositiveInteger() {
        int n;
        //nhập từ bàn phím, xài kĩ thuật OOP, chấm và bung lụa, name.charAt()
        
        Scanner myKeyboard = new Scanner(System.in);
        
        System.out.print("Input a positive integer: ");
        n = myKeyboard.nextInt();
        
        return n;
    }
    
    public static void printfIntegerList(int n) {
        //chỉ có thằng ngáo mới scanf(n) here!!
        
        System.out.println("The list of " + n + " first integers");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void printfIntegerList() {
        System.out.println("The list of 100 first integers");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }   
    
    public static void playWithBoolean () {
        //C: đúng: 1    sai: 0
        //Java: đúng; true      sai: false
        
        boolean marriedStatus = false;
        if (marriedStatus == true) 
            System.out.println("Đánh đòn có địch!");
        else
            System.out.println("Vườn hồng có lối!");
    }
    
    public static void playWithCharacters() {
        //2 byte cho kiểu char, lưu Unicode
        
        char m = '$';
        System.out.println("unit: " + m);
        
        //tên em thì sao? C: mảng các kí tự, ko primitive nữa rồi, phức tạp rồi
        //                char c[] = "..."
        
        String name = "Nguyễn Minh Cường";      //loại data type mới hoàn toàn
                                                //phức ạp, do gồm n thứ khác
                                                //object dât type, học sớm hoi
                                                
        System.out.println("My name is: " + name);
        System.out.println("My first letter of my name is: " + name.charAt(0));
        System.out.println("My name as in a uppercase: " + name.toUpperCase());
        
    }
    
    public static void playWithDoubles() {
        //Java ưu tiên double hơn float
        
        double pi = 3.14;
        System.out.println("pi: " + pi);
        System.out.printf("pi: %.2f\n", pi); //cấm tuyệt đối không dùng %lf
        
        float vat = 0.1F;
        System.out.println("vat: " + vat);
    }
    
    public static void playWithIntegers() {
        int n = 39;     //mọi con số, kí tự xuất hiện trong code được gọi là
                        //literal value
                        //mọi số nguyên xuất hiện trong code mặc định là int
                        
        System.out.println("n: " + n);
        
        long m = 3000000000L;
        System.out.println("m: " + m);
        
        int status = 0xFA; //he 16
        System.out.println("status: " + status);
        
        int phone = 010; //he 8 có số 0 đằng trước
        System.out.println("phone: " + phone);
    }
    
    public static void playWithVaruables() {
        //biến là vùng ram được đặt tên chiếm một số byte nhất định
        //tùy dữ liệu/thông tin mà nó sẽ chứa bên trong
        //biến là cách đặt tên cho 1 đại lượng, giá trị - đơn, phức
        
        int age = 20;
        int a = 10, b;
        b = 100;
        System.out.println("age: " + age);
        
        int yob = 2004; //year of birth
        age = 2023 - yob;
        System.out.println("age again: " + age);
        
        System.out.println("age by using transitive: " + (2023 - yob));
        
        System.out.printf("aga printed by using %% as in C: %d\n", (2023 - yob));
    }
    
}
