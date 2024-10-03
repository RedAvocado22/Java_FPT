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

/**
 *
 * @author Minh Cuong
 */
public class HistoryBO {

    private List<History> histories;

    public HistoryBO(List<History> histories) {
        this.histories = histories;
    }

    /**
     * Record the salary update in the history list.
     *
     * @param w Worker whose salary has been updated
     * @param UPDATE_OPTION "UP" if salary increased, "DOWN" if salary decreased
     */
    public void add(Worker w, String UPDATE_OPTION) {
        History h = new History(
                UPDATE_OPTION,
                Helper.getCurrentDate(),
                w.getId(),
                w.getName(),
                w.getAge(),
                w.getSalary(),
                w.getWorkLocation()
        );

        histories.add(h);
    }

    /**
     * Sort histories by worker's id then by date.
     */
    private void sort() {
        Collections.sort(histories, Comparator
                .comparing(History::getId)
                .thenComparing(History::getDate)
        );
    }

    /**
     * Display histories.
     */
    public void display() {
        System.out.print("------------- Display Information Salary -------------");
        System.out.printf(
                "\n%-5s %-15s %-6s %-5s %-7s %-10s",
                "Code", "Name", "Age", "Salary", "Status", "Date"
        );

        sort();

        for (History h : histories) {
            h.display();
        }
    }
}
