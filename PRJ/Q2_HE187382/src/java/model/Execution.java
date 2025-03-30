/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package model;

import java.util.Objects;

/**
 *
 * @author Minh Cuong
 */
public class Execution {
    
    private String str, option;
    private int result;

    public Execution() {
    }

    public Execution(String str, String option, int result) {
        this.str = str;
        this.option = option;
        this.result = result;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.str);
        hash = 89 * hash + Objects.hashCode(this.option);
        hash = 89 * hash + this.result;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Execution other = (Execution) obj;
        if (this.result != other.result) {
            return false;
        }
        if (!Objects.equals(this.str, other.str)) {
            return false;
        }
        return Objects.equals(this.option, other.option);
    }
    
}
