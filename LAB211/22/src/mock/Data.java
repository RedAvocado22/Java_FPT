/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import constant.IConstant;
import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;


public class Data {

    public static List<Candidate> candidates = new ArrayList<>();

    static {
        candidates.add(new Intern(1, "Nguyen", "Hoang", 2003, "Ha Tay",
                "0327811016", "huynxhe170420@gmail.com",
                IConstant.INTERN_TYPE, "SE", 9, "FPT"));
        candidates.add(new Intern(2, "Nguyen", "A", 2002, "Nghe An",
                "0327811016", "abc@gmail.com",
                IConstant.INTERN_TYPE, "SE", 9, "FPT"));
        candidates.add(new Intern(3, "Nguyen", "B", 2001, "Ha Tinh",
                "0327811016", "bcd@gmail.com",
                IConstant.INTERN_TYPE, "SE", 9, "FPT"));
        candidates.add(new Intern(4, "Nguyen", "C", 2000, "Ha Noi",
                "0327811016", "def@gmail.com",
                IConstant.INTERN_TYPE, "SE", 9, "FPT"));
        candidates.add(new Experience(5, "Nguyen", "D", 2000, "Ha Noi",
                "0327811016", "def@gmail.com",
                IConstant.EXPERIENCE_TYPE, 3, "FrontEnd"));
        candidates.add(new Fresher(6, "Nguyen", "E", 2000, "Ha Noi",
                "0327811016", "def@gmail.com",
                IConstant.FRESHER_TYPE, 2021, "FPT", "Very Good"));
    }
}
