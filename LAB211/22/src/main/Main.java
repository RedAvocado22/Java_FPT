/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */

package main;

import bo.CandidateBO;
import constant.IConstant;
import mock.Data;
import util.Helper;
import util.Validate;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CandidateBO candidateBO = new CandidateBO(Data.candidates);
        
        String name = "";
        int type = -1;
        
        do {
            Helper.menu();
            
            int choice = Validate.getInt(
                    "Choice: ", 
                    IConstant.RANGE_MES, 
                    IConstant.INTEGER_MES, 
                    1, 5
            );
            
            switch (choice) {
                case 1 -> {
                    candidateBO.add(IConstant.EXPERIENCE_TYPE);
                }
                
                case 2 -> {
                    candidateBO.add(IConstant.FRESHER_TYPE);
                }
                
                case 3 -> {
                    candidateBO.add(IConstant.INTERN_TYPE);
                }
                
                case 4 -> {
                    name = Validate.getString(
                            "Enter candidate's name: ", 
                            IConstant.STRING_MES, 
                            IConstant.REGEX_NAME
                    );
                    
                    Helper.menuOfCandidateType();
                    type = Validate.getInt("Enter type: ", IConstant.RANGE_MES, IConstant.INTEGER_MES, 1, 3);
                    
                    candidateBO.display(candidateBO.search(name, type - 1));
                }
                
                case 5 -> {
                    System.out.println("Good bye!");
                    return;
                }
            }
            
        } while (true);
    }

}
