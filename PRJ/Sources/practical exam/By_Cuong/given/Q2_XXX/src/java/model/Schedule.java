/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

import java.util.Date;

/**
 *
 * @author Minh Cuong
 */
public class Schedule {
    private int code;
    private String name;
    private Date date;

    public Schedule() {
    }

    public Schedule(int code, String name, Date date) {
        this.code = code;
        this.name = name;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

}
