/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

import constant.IConstant;
import java.util.List;
import util.Validate;

/**
 *
 * @author Minh Cuong
 */
public class Worker {

    private String id, name;
    private int age, salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String id,
            String name,
            int age, int salary,
            String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    /**
     * Get id from input validation.
     * 
     * @param list the list to check for duplicate IDs when getting new ID.
     * @return unique ID for worker.
     */
    private String getId(List<Worker> list) {
        do {
            String id = Validate.getString(
                    "Enter ID: ",
                    "Invalidated id! Try again!",
                    IConstant.REGEX_ID
            );

            boolean isExist = list.stream().anyMatch(c -> c.getId().equals(id));

            if (isExist) {
                System.out.println("ID is exist! Try again!");
            } else {
                return id;
            }
        } while (true);
    }

    /**
     * Setting worker attributes through user input validation.
     * 
     * @param list the list to check for duplicate IDs when getting new ID.
     */
    public void input(List<Worker> list) {
        this.id = getId(list);

        this.name = Validate.getString(
                "Enter name: ",
                "Invalidated id! Try again!",
                IConstant.REGEX_NAME
        );

        this.age = Validate.getInt(
                "Enter age: ",
                "Age must be greater than 18 and smaller than 50!",
                "Age must be an integer!",
                IConstant.MIN_AGE,
                IConstant.MAX_AGE
        );

        this.salary = Validate.getInt(
                "Enter salary: ",
                "Salary must be positive!",
                "Salary must be an integer!",
                0,
                Integer.MAX_VALUE
        );

        this.workLocation = Validate.getString(
                "Enter work location: ",
                "Invalidated location! Try again!",
                IConstant.REGEX_ADDRESS
        );
    }

    /**
     * Display worker's information.
     */
    public void display() {
        System.out.printf(
                "\n%-5s %-15s %-5d %-5d %-10s", 
                id, name, age, salary, workLocation
        );
    }
}
