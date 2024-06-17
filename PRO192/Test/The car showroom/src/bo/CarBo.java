/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package bo;

import constant.IConstant;
import entity.Brand;
import entity.Car;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import util.Menu;
import util.Validate;

/**
 *
 * @author Admin
 */
public class CarBo {
  
  private List<Car> list;
  private List<Brand> brandList = new ArrayList<>();
  
  public CarBo(List<Car> list) {
    this.list = list;
  }

  public void setBrandList(List<Brand> brandList) {
    this.brandList = brandList;
  }
  
  /**
   * Load car list from a 'txt' file.
   * 
   * @return loaded successful or not.
   */
  public boolean loadFromFile() {
    if (!list.isEmpty())
      list.removeAll(list);

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

        Car tmp = new Car();
        if(!tmp.parse(line, brandList)) {
          return false;
        }

        list.add(tmp);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException ex) {
          Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      if (bufferReader != null) {
        try {
          bufferReader.close();
        } catch (IOException ex) {
          Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return true;
  }

  /**
   * Save car list from a 'txt' file.
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
      Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException ex) {
          Logger.getLogger(CarBo.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return true;
  }
  
  /**
   * Search car.
   * 
   * @param TYPE the search type user need.
   * @return position of brand need to find in list.
   */
  public int search(final String TYPE) {
    String ID;
    
    switch (TYPE) {
      case IConstant.TYPE_ID:
        ID = Validate.getString("Enter car's ID: ", 
                                 "Car's ID is invalidated!", 
                                 IConstant.REGEX_CAR_ID);
        
        return IntStream.range(0, list.size())
                .filter(x -> list.get(x).getCarID().equals(ID))
                .findFirst().orElse(-1);
        
      case IConstant.TYPE_FRAME:
        ID = Validate.getString("Enter frame's ID: ", 
                                 "Frame's ID is invalidated!", 
                                 IConstant.REGEX_FRAME_ID);
        
        return IntStream.range(0, list.size())
                .filter(x -> list.get(x).getFrameID().equals(ID))
                .findFirst().orElse(-1);
        
      case IConstant.TYPE_ENGINE:
        ID = Validate.getString("Enter frame's ID: ", 
                                 "Frame's ID is invalidated!", 
                                 IConstant.REGEX_ENGINE_ID);
        
        return IntStream.range(0, list.size())
                .filter(x -> list.get(x).getEngineID().equals(ID))
                .findFirst().orElse(-1);
    }
    
    return -1;
  }
  
  /**
   * Turn brand list to menu.
   * 
   * @return menu that have all brands information.
   */
  private int brandMenu() {
    Menu menu = new Menu("List of brand");

    for(int i = 0; i < brandList.size(); i++) {
      menu.addNewOption((i + 1) + ". " + brandList.get(i).toString());
    }
    
    menu.printMenu();
    int choice = menu.getChoice();
    
    return choice;
  }
  
  /**
   * Add a new car to the list.
   */
  public void add() {
    Car car = new Car();
    
    car.input(list, brandList.get(brandMenu() - 1));
    list.add(car);
    
    System.out.println("Added a new car successful!");
  }
  
  /**
   * Display all the car of brand.
   */
  public void displayByBrandName() {
    String partOfBrandName = Validate.getString(
            "Enter brand's name (It can be just a part of name): ", 
            "Invalidated brand's name!", 
            IConstant.REGEX_BRAND_NAME
    );
    
    System.out.println("Here is the list of " + partOfBrandName + " brand: ");
    list.forEach((car) -> {
      if(car.getBrand().getBrandName().contains(partOfBrandName)) {
        car.display();
      }
    });
  }
  
  /**
   * Remove a car by its car's ID.
   * 
   * @param index the position of car need to remove.
   * @return remove successful or not.
   */
  public boolean remove(int index) {
    if (index < 0) {
      System.out.println("The car isn't exist!");
      return false;
    }
    
    list.remove(index);
    return true;

  }
  
  /**
   * Update information a car.
   * 
   * @param TYPE the update type that user need.
   * @return successful or not.
   */
  public boolean update(final String TYPE, int index) {
    
    switch (TYPE) {
      case IConstant.BRAND_OPTION:
        System.out.println("Choice new brand for the car: ");
        list.get(index).setBrand(brandList.get(brandMenu() - 1));
        break;
      case IConstant.TYPE_COLOR:
        list.get(index).setColor(
          Validate.getString("Enter new car's color: ",
          "Invalidated color!",
          IConstant.REGEX_TEXT)
        );
        break;
      case IConstant.TYPE_FRAME:
        list.get(index).getFrameId(list);
        break;
      case IConstant.TYPE_ENGINE:
        list.get(index).getEngineId(list);
        break;
    }
    
    return true;
  }
  
  /**
   * Sort the list by brand name then car's ID.
   */
  public void sort() {
    this.list.sort(Comparator.comparing(Car::getBrandName)
                   .thenComparing(Car::getCarID));
  }
  
  /**
   * Display all cars in list.
   */
  public void display() {
    if(list.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }
    
    System.out.println("Here all the car: ");
    list.forEach((car) -> {
      car.display();
    });
  }
  
  /**
   * Display one car.
   * 
   * @param index the position of car need to display.
   */
  public void displayOne(int index) {
    list.get(index).display();
  }
}
