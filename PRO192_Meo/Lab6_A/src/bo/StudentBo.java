/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.IConstant;
import entity.Student;
import java.util.List;
import util.Helper;

/**
 *
 * @author Admin
 */
public class StudentBo {
    
    private List<Student> list;

    public StudentBo() {
    }
    
    public StudentBo(List<Student> list) {
        this.list = list;
    }
    
    public void add() {
        do {
            Student student = new Student();
            student.input(list);
            list.add(student);
        } while (Helper.isContinue());
    }
    
    public void display() {
        if (list.isEmpty()) {
            System.out.println("\n Not Found");
        } else {
            for (int index = 0; index < list.size(); index++) {
                System.out.println("------ Student " + (index + 1) + " Info ------");
                list.get(index).display();
            }
        }
    }
    
    public int search(String code) {
        int index;
        
        if (list.isEmpty()) {
            System.out.println("\n Not Found");
            return -1;
        } else {
            for (index = 0; index < list.size(); index++) {
                if (list.get(index).getCode().equalsIgnoreCase(code)) {
                    return index;
                }
            }
        }
        return -1;
    }
    
    public void remove(int index) {
        list.remove(index);
        System.out.println("Remove succesful!");
    }
    
    public void update(int index, String type) {
        if (type.equalsIgnoreCase(IConstant.MARK_TYPE)) {
            list.get(index).setMark();
        } else {
            list.get(index).setName();
        }
    }

    public void displayOne(int index) {
        list.get(index).display();
    }
}
