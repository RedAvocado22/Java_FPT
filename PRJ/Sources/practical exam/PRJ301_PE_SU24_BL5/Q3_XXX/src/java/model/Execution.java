/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dkien
 */
public class Execution {

    private int id;
    private String inputString;
    private int subIndex;
    private String result;
    private String typeName;

    public Execution() {
    }

    public Execution(int id, String inputString, int subIndex, String result, String typeName) {
        this.id = id;
        this.inputString = inputString;
        this.subIndex = subIndex;
        this.result = result;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public int getSubIndex() {
        return subIndex;
    }

    public void setSubIndex(int subIndex) {
        this.subIndex = subIndex;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Execution{" + "id=" + id + ", inputString=" + inputString + ", subIndex=" + subIndex + ", result=" + result + ", typeName=" + typeName + '}';
    }

}
