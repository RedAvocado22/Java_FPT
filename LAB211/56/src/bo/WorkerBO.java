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
    private List<History> historys;

    public WorkerBO(List<Worker> workers, List<History> historys) {
        this.workers = workers;
        this.historys = historys;
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

        recordHistory(w, UPDATE_OPTION);
    }

    /**
     * Record the salary update in the history list.
     * 
     * @param w Worker whose salary has been updated
     * @param UPDATE_OPTION "UP" if salary increased, "DOWN" if salary decreased
     */
    private void recordHistory(Worker w, String UPDATE_OPTION) {
        History h = new History(
                UPDATE_OPTION,
                Helper.getCurrentDate(),
                w.getId(),
                w.getName(),
                w.getAge(),
                w.getSalary(),
                w.getWorkLocation()
        );

        historys.add(h);
    }

    private void sortHistorys() {
        Collections.sort(historys, Comparator
                .comparing(History::getId)
                .thenComparing(History::getDate)
        );
    }
    public void displayHistory() {
        System.out.print("------------- Display Information Salary -------------");
        System.out.printf(
                "\n%-5s %-15s %-6s %-5s %-7s %-10s",
                "Code", "Name", "Age", "Salary", "Status", "Date"
        );

        sortHistorys();
        
        for (History h : historys) {
            h.display();
        }
    }
}
