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
public class Supplier {
    
    private String code, name, gender, typeID, typeName;
    private String dob;
    
    public Supplier() {
    }

    public Supplier(String code, String name, String dob, String gender, String typeID, String typeName) {
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
