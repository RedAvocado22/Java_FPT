/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.CandidateBo;
import constant.IConstant;
import mock.Data;
import util.Helper;
import util.Validate;


public class Main {

    public static void main(String[] args) {
        CandidateBo candidateBo = new CandidateBo(Data.listCandidate);
        boolean flag = true;
        do {
            Helper.menu();
            int choice = Validate.getInt(
                    "Enter your choice: ",
                    "Numeric value out of range",
                    "Invalid integer number",
                    1, 5);
            switch (choice) {
                case 1:
                    System.out.println();
                    candidateBo.add(IConstant.EXPERIENCE_TYPE);
                    break;
                case 2:
                    System.out.println();
                    candidateBo.add(IConstant.FRESHER_TYPE);
                    break;
                case 3:
                    System.out.println();
                    candidateBo.add(IConstant.INTERN_TYPE);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("=======EXPERIENCE CANDIDATE=======");
                    candidateBo.displayCandidateNameByType(IConstant.EXPERIENCE_TYPE);
                    System.out.println("=======FRESHER CANDIDATE=======");
                    candidateBo.displayCandidateNameByType(IConstant.FRESHER_TYPE);
                    System.out.println("=======INTERN CANDIDATE=======");
                    candidateBo.displayCandidateNameByType(IConstant.INTERN_TYPE);
                    String text = Validate.getString(
                            "Input Candidate name(first name or last name): ",
                            "Invalid name",
                            IConstant.REGEX_NAME);
                    int type = Validate.getInt(
                            "Input type of candidate [0-1-2] "
                            + "(0: Experience, "
                            + "1: Fresher, "
                            + "2: Intern): ",
                            "Numeric value out of range",
                            "Invalid integer number",
                            0, 2);
                    candidateBo.display(candidateBo.search(text, type));
                    break;
                case 5:
                    flag = false;
                    break;

            }
        } while (flag);
    }

}
