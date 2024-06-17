/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package mock;

import java.util.ArrayList;
import java.util.List;
import model.Phone;

/**
 *
 * @author Admin
 */
public class Data {
  public static List<Phone> listPhone = new ArrayList<>();

  static {
    listPhone.add(new Phone("Cuong", "0358963227"));
    listPhone.add(new Phone("Hai",   "0333333333"));
    listPhone.add(new Phone("Nam",   "0332132133"));
    listPhone.add(new Phone("Vinh",  "0394677457"));
    listPhone.add(new Phone("Toan",  "0976868634"));
    listPhone.add(new Phone("Vu",    "0851231231"));
  }
}
