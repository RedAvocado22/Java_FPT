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

    private String str;
    private int index;
    private String result;

    public Execution() {
    }

    public Execution(String str, int index, String result) {
        this.str = str;
        this.index = index;
        this.result = result;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Execution{" + "str=" + str + ", index=" + index + ", result=" + result + '}';
    }

}
