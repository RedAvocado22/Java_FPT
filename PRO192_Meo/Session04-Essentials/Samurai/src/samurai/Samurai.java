/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samurai;

import java.util.Scanner;

/**
 *
 * @author FPT Shop
 */
public class Samurai {

    public static void main(String[] args) {
        inputProfileXinSo();
    }

    public static void inputProfileXinSo() {
        String name, address;
        int yob;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = sc.nextLine().toUpperCase();

        while (true) { //vòng lặp vô tận
            try {
                System.out.print("Enter yob: ");
                yob = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Do ku know to input a positive number?");
            }
        }

        System.out.print("Enter address: ");
        address = sc.nextLine().toUpperCase();

        outputProfile(name, address, yob);
    }

    public static void inputProfile() {
        String name, address;
        int yob;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = sc.nextLine().toUpperCase();

        try {
            //lệnh cà chớn nằm đây
            System.out.print("Enter yob: ");
            yob = Integer.parseInt(sc.nextLine());
            //alt + shift + f để căn chỉnh các lệnh
        } catch (Exception e) {
            //CPU sẽ chạy đến đây nếu cà chớn xảy ra và xử lí hậu quả cà chớn
            //JVM sẽ không giết app như truyền thống nữa
            //Không cà chớn không vào đay
            //"e" chính là lá thư/msg màu đỏ JVM gửi cho mình để báo lỗi cho mình
            //Expection e = new Exception(nội dung lỗi màu đỏ đây nè..);
            //về lí: e.xem lỗi, xử lý tự mình
            //về toán với hóa, mình chỉ tập trung phần xử lý lỗi, biết thừa éo gõ đúng số mình muốn

            //xử lý ra sao??? nhiều cách
            yob = 69; //sử dụng default value (không hay)
        }

        System.out.print("Enter address: ");
        address = sc.nextLine().toUpperCase();

        outputProfile(name, address, yob);
    }

    public static void outputProfile(String name, String address, int yob) {
        System.out.println("\nHere is your profile");
        System.out.println("Name: " + name);
        System.out.println("YOB: " + yob);
        System.out.println("Address: " + address);
    }

}
