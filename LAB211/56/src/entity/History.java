/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package entity;

/**
 *
 * @author Minh Cuong
 */
public class History extends Worker {

    String status, date;

    public History(String status, 
                   String date, 
                   String id, 
                   String name,
                   int age, 
                   int salary, 
                   String workLocation) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void display() {
        System.out.printf(
                "\n%-5s %-15s %-6d %-6d %-7s %-10s", 
                super.getId(),
                super.getName(),
                super.getAge(),
                super.getSalary(),
                this.status,
                this.date
        );
    }
}
