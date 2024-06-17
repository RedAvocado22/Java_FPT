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
 * @author Admin
 */
public class Car {

  private String carID, color, frameID, engineID;
  private Brand brand;

  public Car() {
  }

  public Car(String carID, Brand brand, String color, String frameID, String engineID) {
    this.carID = carID;
    this.color = color;
    this.frameID = frameID;
    this.engineID = engineID;
    this.brand = brand;
  }

  //End constructor.
  public String getCarID() {
    return carID;
  }

  public String getColor() {
    return color;
  }

  public String getFrameID() {
    return frameID;
  }

  public String getEngineID() {
    return engineID;
  }

  public Brand getBrand() {
    return brand;
  }

  //End getter.
  public void setCarID(String carID) {
    this.carID = carID;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setFrameID(String frameID) {
    this.frameID = frameID;
  }

  public void setEngineID(String engineID) {
    this.engineID = engineID;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  //End setter.
  @Override
  public String toString() {
    return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID + "\n";
  }

  public String getBrandName() {
    return getBrand().getBrandName();
  }
  /**
   * Get id from input validation.
   *
   * @param list the list to loop through to check if id is duplicated or not.
   * @return valid id from input
   */
  private String getId(List<Car> list) {
    while (true) {
      String code = Validate.getString("Enter car's ID: ",
              "Invalidated car's ID!",
              IConstant.REGEX_CAR_ID);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getCarID().trim().equalsIgnoreCase(code)) {
          isExist = true;
          break;
        }
      }

      if (isExist) {
        System.out.println("ID is exist, try again");
      } else {
        return code;
      }
    }
  }
  
  /**
   * Get id from input validation.
   *
   * @param list the list to loop through to check if id is duplicated or not.
   * @return valid id from input
   */
  public String getFrameId(List<Car> list) {
    while (true) {
      String code = Validate.getString("Enter car's frame ID: ",
              "Invalidated car's frame ID!",
              IConstant.REGEX_FRAME_ID);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getFrameID().trim().equalsIgnoreCase(code)) {
          isExist = true;
          break;
        }
      }

      if (isExist) {
        System.out.println("ID is exist, try again");
      } else {
        return code;
      }
    }
  }
  
  /**
   * Get id from input validation.
   *
   * @param list the list to loop through to check if id is duplicated or not.
   * @return valid id from input
   */
  public String getEngineId(List<Car> list) {
    while (true) {
      String code = Validate.getString("Enter car's engine ID: ",
              "Invalidated car's engine ID!",
              IConstant.REGEX_ENGINE_ID);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getEngineID().trim().equalsIgnoreCase(code)) {
          isExist = true;
          break;
        }
      }

      if (isExist) {
        System.out.println("ID is exist, try again");
      } else {
        return code;
      }
    }
  }

  /**
   * Input a new car.
   *
   * @param list  the list to loop through to check if id is duplicated or not.
   * @param brand the brand for the car.
   */
  public void input(List<Car> list, Brand brand) {
    this.brand = brand;

    this.carID = getId(list);

    this.color = Validate.getString("Enter car's color: ",
                                    "Invalidated color!",
                                    IConstant.REGEX_TEXT);

    this.frameID = getFrameId(list);

    this.engineID = getEngineId(list);
  }

  /**
   * Display car.
   */
  public void display() {
    System.out.println(carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID);
  }
  
   /**
   * Parses a line of text to extract car attributes and populate them into the
   * Car object.
   *
   * @param line the line of text containing car information, with attributes
   *             separated by ", ".
   * @param list the list of Brand objects to find the corresponding brand for
   *             the car.
   * @return Added successful or not.
   */
  public boolean parse(String line, List<Brand> list) {
    String[] params = line.split("\\, ");

    try {
      this.carID = params[0].trim();
      int index;

      for (index = 0; index < list.size(); index++) {
        if(list.get(index).getBrandID().equalsIgnoreCase(params[1].trim())) {
          this.brand = list.get(index);
          break;
        }
      }
      
      if(index++ >= list.size() || list.isEmpty()) {
        return false;
      }
      this.color = params[2].trim();
      this.frameID = params[3].trim();
      this.engineID = params[4].trim();
    } catch (ArrayIndexOutOfBoundsException ex) {
    } finally {
    }
    return true;
  }
}
