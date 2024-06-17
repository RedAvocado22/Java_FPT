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
public class Brand {

  private String brandID, brandName, soundBrand;
  double price;

  public Brand() {
  }

  public Brand(String brandID, String brandName, String soundBrand, double price) {
    this.brandID = brandID;
    this.brandName = brandName;
    this.soundBrand = soundBrand;
    this.price = price;
  }

  //End constructor.
  public String getBrandID() {
    return brandID;
  }

  public String getBrandName() {
    return brandName;
  }

  public String getSoudBrand() {
    return soundBrand;
  }

  public double getPrice() {
    return price;
  }

  //End getter.
  public void setBrandID(String brandID) {
    this.brandID = brandID;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public void setSoudBrand(String soudBrand) {
    this.soundBrand = soudBrand;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  //End setter.
  @Override
  public String toString() {
    return brandID + ", " + brandName + ", " + soundBrand + ": " + price + "\n";
  }

  /**
   * Get id from input validation.
   *
   * @param list the list to loop through to check if id is duplicated or not.
   * @return valid id from input
   */
  private String getId(List<Brand> list) {
    while (true) {
      String code = Validate.getString("Enter brand's ID: ",
                                       "Invalidated brand's ID!",
                                       IConstant.REGEX_BRAND_ID);

      boolean isExist = false;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getBrandID().trim().equalsIgnoreCase(code)) {
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
   * Input a brand.
   * 
   * @param list the list to loop through to check if id is duplicated or not.
   */
  public void input(List<Brand> list) {
    this.brandID = getId(list);
    
    this.brandName = Validate.getString("Enter brand's name: ", 
                                        "Invalidated brand's name!", 
                                        IConstant.REGEX_BRAND_NAME);
    
    this.soundBrand = Validate.getString("Enter sound brand: ", 
                                         "Invalidated sound brand!", 
                                         IConstant.REGEX_TEXT);
    
    this.price = Validate.getDouble("Enter the price: ", 
                                    "Price need to be positive!", 
                                    "Price need to be a digit!", 
                                    0, Double.MAX_VALUE);
  }

  /**
   * Display the brand.
   */
  public void display() {
    System.out.println(brandID + ", " + brandName + ", " + soundBrand + ": " + price);
  }
  
  /**
   * <p> Parses a line of text to extract brand attributes and populate them into
   * the Brand object.
   *
   * The input line should be in the format: "brandID, brandName, soundBrand:
   * price" </p>
   *
   * @param line the line of text containing brand information, with attributes
   * separated by ", " and ": ".
   */
  public void parse(String line) {
    String[] params = line.split("\\, ");

    try {
      this.brandID = params[0].trim();
      this.brandName = params[1].trim();
      String[] param = params[2].split("\\: ");
      this.soundBrand = param[0].trim();
      this.price = Double.parseDouble(param[1].trim());
    } catch (ArrayIndexOutOfBoundsException ex) {
    } finally {
    }
  }
}
