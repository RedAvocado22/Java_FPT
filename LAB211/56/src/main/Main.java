/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.HistoryBO;
import bo.WorkerBO;
import constant.IConstant;
import entity.History;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;
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
        List<Worker> workers = Data.workers;

        WorkerBO workerBo = new WorkerBO(workers);
        HistoryBO historyBo = new HistoryBO(new ArrayList());

        do {
            Helper.menu();

            String id;
            Worker w;
            int choice = Validate.getInt(
                    "Enter choice: ",
                    "Choice must be from 1 to 5!",
                    "Choice must be an integer!",
                    1, 5
            );

            switch (choice) {
                case 1 -> {
                    workerBo.add();
                }

                case 2 -> {
                    id = Validate.getString(
                            "Enter worker's id need to update: ",
                            "Invalidated id!",
                            IConstant.REGEX_ID
                    );

                    w = workerBo.search(id);

                    if (w != null) {
                        workerBo.updateSalary(IConstant.UP, w);
                        historyBo.add(w, IConstant.UP);
                    } else {
                        System.out.println("The worker not exist!");
                    }

                }

                case 3 -> {
                    id = Validate.getString(
                            "Enter worker's id need to update: ",
                            "Invalidated id!",
                            IConstant.REGEX_ID
                    );

                    w = workerBo.search(id);

                    if (w != null) {
                        workerBo.updateSalary(IConstant.DOWN, w);
                        historyBo.add(w, IConstant.DOWN);
                    } else {
                        System.out.println("The worker not exist!");
                    }
                }

                case 4 -> {
                    historyBo.display();
                }

                case 5 -> {
                    System.out.println("Good bye!");
                    return;
                }
            }
        } while (true);
    }

}
