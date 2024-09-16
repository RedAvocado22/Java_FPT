/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package mock;

import entity.Worker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh Cuong
 */
public class Data {

    public static List<Worker> workers = new ArrayList<>();

    static {
        workers.add(new Worker("W001", "Thang", 20, 1500, "Ha Noi"));
        workers.add(new Worker("W002", "Cuong", 20, 2000, "Ha Giang"));
        workers.add(new Worker("W003", "Linh", 20, 2500, "Thai Nguyen"));
    }
}
