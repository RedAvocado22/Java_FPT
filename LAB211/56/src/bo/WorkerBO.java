/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import entity.History;
import entity.Worker;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import util.Helper;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class WorkerBO {

    private List<Worker> workers;

    public WorkerBO(List<Worker> workers, List<History> historys) {
        this.workers = workers;
        this.histories = historys;
    }

    /**
     * Add a new worker to the list.
     */
    public void add() {
        do {
            Worker w = new Worker();
            w.input(workers);
            workers.add(w);
        } while (Helper.isContinue());
    }

    /**
     * Search for a worker by ID.
     * 
     * @param id Worker ID to search for
     * @return Worker object if found, otherwise null
     */
    public Worker search(String id) {
        return workers.stream()
                      .filter(w -> w.getId().equals(id))
                      .findFirst()
                      .orElse(null);
    }
    
    /**
     * Update a worker's salary either by increasing or decreasing it.
     * 
     * @param UPDATE_OPTION Option to increase ("UP") or decrease ("DOWN") salary
     * @param w Worker whose salary is being updated
     */
    public void updateSalary(String UPDATE_OPTION, Worker w) {
        int amount = Validate.getInt(
                "Enter salary: ",
                "Salary must be positive!",
                "Salary must be an integer!",
                0, Integer.MAX_VALUE
        );

        switch (UPDATE_OPTION) {
            case "UP" -> {
                w.setSalary(w.getSalary() + amount);
            }
            case "DOWN" -> {
                if (amount > w.getSalary()) {
                    amount = 0;
                }
                w.setSalary(w.getSalary() - amount);
            }
        }
    }
}
