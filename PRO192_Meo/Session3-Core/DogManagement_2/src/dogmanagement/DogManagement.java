/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogmanagement;

import data.Dog;


public class DogManagement {

    public static void main(String[] args) {
        //lấy khuôn DOg ra để đổ in4
        //y chang làm thẻ căn cước: lấy thông tin, in lên thẻ, đổ mực
        //đặt tên tắt cho object để dễ truyền tham chiếu và gọi
        Dog chiHu = new Dog("Chi Hu Hu", 2021, 0.5);
        Dog ngaoDa = new Dog("Ngao Da", 2020, 1.5);
        System.out.println("Chi Hu Hu : " + chiHu.toString());
        System.out.println("Chi Hu Hu : " + ngaoDa);
    }
    
}
