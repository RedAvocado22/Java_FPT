/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import constant.IConstant;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import util.Helper;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class CandidateBO {

    private List<Candidate> candidates;

    public CandidateBO() {
    }

    public CandidateBO(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public void add(final int TYPE) {
        do {
            Candidate c = null;

            switch (TYPE) {
                case 0 -> {
                    c = new Experience();
                }

                case 1 -> {
                    c = new Fresher();
                }

                case 2 -> {
                    c = new Intern();
                }
            }

            if (c != null) {
                c.input(generateId());
                this.candidates.add(c);
            } else {
                System.out.println(
                        "An error has occurred. Can not add new candidate"
                );
            }
        } while (Helper.isContinue());
    }

    public List<Candidate> search(String name, int type) {
        return this.candidates.stream()
                .filter(
                        c -> c.getFullName().toLowerCase()
                              .contains(name.toLowerCase())
                )
                .filter(c -> c.getType() == type)
                .toList();
    }

    public void display(List<Candidate> list) {
        if (list.isEmpty()) {
            System.out.println("\nNot found!");
        } else {
            System.out.printf(
                    "\n%-5s%-20s%-15s%-10s%-15s%-25s%-10s",
                    "ID", "Full name", "Birth date",
                    "Address", "Phone", "Email", "Type"
            );
            
            list.stream().forEach(c -> c.display());
        }
    }

    private int generateId() {
        do {
            int id = Validate.getInt(
                    "Enter id: ",
                    IConstant.RANGE_MES,
                    IConstant.INTEGER_MES,
                    1, Integer.MAX_VALUE
            );

            boolean isExist = this.candidates.stream()
                    .anyMatch(c -> c.getId() == id);

            if (isExist) {
                System.out.println("Id is existed!");
            } else {
                return id;
            }
        } while (true);
    }
}
