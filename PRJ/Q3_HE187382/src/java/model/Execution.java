/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

/**
 *
 * @author Minh Cuong
 */
public class Execution {

    private int id;
    private String str;
    private int result, typeID;
    private String typeName;

    public Execution() {
    }

    public Execution(int id, String str, int result, int typeID, String typeName) {
        this.id = id;
        this.str = str;
        this.result = result;
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}

