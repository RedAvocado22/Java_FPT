/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import constant.IConstant;
import entity.Brand;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import util.Validate;

/**
 *
 * @author Admin
 */
public class BrandBo {

  private List<Brand> list;

  public BrandBo() {
  }

  public BrandBo(List<Brand> list) {
    this.list = list;
  }

  public List<Brand> getList() {
    return list;
  }

  /**
   * Load brand list from a 'txt' file.
   * 
   * @return loaded successful or not.
   */
  public boolean loadFromFile() {
    if(!list.isEmpty()) {
      list.removeAll(list);
    }

    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader bufferReader = null;

    try {
      String fileName = Validate.getString("Enter file path: ",
              "Error file path!",
              IConstant.REGEX_FILE);

      File file = new File(fileName);

      if (!file.exists()) {
        System.out.println("File not exist!");
        return false;
      }

      fis = new FileInputStream(fileName);

      reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

      bufferReader = new BufferedReader(reader);

      String line = null;

      while ((line = bufferReader.readLine()) != null) {
        if ((line.isEmpty())) {
          continue;
        }

        Brand tmp = new Brand();
        tmp.parse(line);

        this.list.add(tmp);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return true;
  }

  /**
   * Save brand list from a 'txt' file.
   * 
   * @return saved successful or not.
   */
  public boolean saveToFile() {
    if (list.isEmpty()) {
      return false;
    }

    FileOutputStream fos = null;

    try {
      String fileName = Validate.getString("Enter file path: ",
                                           "Error file path!",
                                           IConstant.REGEX_FILE);

      File file = new File(fileName);

      if (!file.exists()) {
        System.out.println("File not exist!");
        return false;
      }

      fos = new FileOutputStream(fileName);

      for (int i = 0; i < list.size(); i++) {
        String line;
        line = list.get(i).toString();
        byte[] b = line.getBytes("utf8");
        fos.write(b);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException ex) {
          Logger.getLogger(BrandBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return true;
  }

  /**
   * Search brand.
   * 
   * @param brandID the id of brand needed to find.
   * @return position of brand need to find in list.
   */
  public int searchID(String brandID) {
    return IntStream.range(0, list.size())
                    .filter(x -> list.get(x).getBrandID().equals(brandID))
                    .findFirst().orElse(-1);
  }
  
  /**
   * Get brand for car.
   * 
   * @param index the brand's position.
   * @return brand information.
   */
  public Brand getBrand(int index) {
    return list.get(index - 1);
  }
  
  /**
   * Add a new brand to list.
   */
  public void add() {
    Brand brand = new Brand();
    brand.input(list);
    list.add(brand);
    System.out.println("Added a new brand to the list!");
  }
  
  /**
   * Update brand information.
   * 
   * @param index the position of brand need to update.   
   * @param TYPE  the update type for brand.
   * @return update successful or not.
   */
  public boolean update(int index, final String TYPE) {
    String string;
    double price;
    displayOne(index);
    
    switch (TYPE) {
      case IConstant.TYPE_NAME:
        string = Validate.getString("Enter new brand's name: ",
                                    "Invalidated brand's name!",
                                    IConstant.REGEX_BRAND_NAME);
        list.get(index).setBrandName(string);
        break;
      case IConstant.TYPE_SOUND_BRAND:
        string = Validate.getString("Enter new sound brand: ", 
                                    "Invalidated sound brand!", 
                                    IConstant.REGEX_TEXT);
        list.get(index).setSoudBrand(string);
        break;
      case IConstant.TYPE_PRICE:
        price = Validate.getDouble("Enter the new price: ", 
                                    "Price need to be positive!", 
                                    "Price need to be a digit!", 
                                    0, Double.MAX_VALUE);
        list.get(index).setPrice(price);
        break;
    }
    
    return true;
  }
  
  /**
   * Display one brand information.
   * 
   * @param index the position of brand need to display.
   */
  public void displayOne(int index) {
    System.out.println("\nHere is the brand you need: ");
    list.get(index).display();
  }
  
  /**
   * Display all brand information.
   */
  public void display() {
    if(list.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }
    list.forEach((brand) -> {
      brand.display();
    });
  }
  
  /**
   * Export brand list.
   * 
   * @return brand list.
   */
  public List<Brand> exportBrandList() {
    return list;
  }
}
