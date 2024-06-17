/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package main;

import bo.BrandBo;
import bo.CarBo;
import constant.IConstant;
import java.util.ArrayList;
import util.Helper;
import util.Menu;
import util.Validate;

/**
 *
 * @author Nguyen Minh Cuong
 */
public class Main {

  public static void main(String[] args) {
    int choice, index;
    String id;

    BrandBo brandBo = new BrandBo(new ArrayList<>());
    CarBo carBo = new CarBo(new ArrayList<>());
    
    Menu menu = new Menu("Car showroom Managerment!");
    menu.addNewOption("1.  List all brand.");
    menu.addNewOption("2.  Add a new brand.");
    menu.addNewOption("3.  Search a brand.");
    menu.addNewOption("4.  Update information a brand.");
    menu.addNewOption("5.  Load brand list from file.");
    menu.addNewOption("6.  Save brand list to file.");
    menu.addNewOption("7.  List all car.");
    menu.addNewOption("8.  Add a new car.");
    menu.addNewOption("9.  Remove a car.");
    menu.addNewOption("10. Update a car.");
    menu.addNewOption("11. Load cars list from file.");
    menu.addNewOption("12. Save cars list to file.");
    menu.addNewOption("13. Exit.");

    Menu menuUpdateBrand = new Menu("Update brand");
    menuUpdateBrand.addNewOption("1. Update brand's name.");
    menuUpdateBrand.addNewOption("2. Update sound brand.");
    menuUpdateBrand.addNewOption("3. Update price.");
    
    Menu menuUpdateCar = new Menu("Update car");
    menuUpdateCar.addNewOption("1. Update car's brand.");
    menuUpdateCar.addNewOption("2. Update car's color.");
    menuUpdateCar.addNewOption("3. Update car's frame.");
    menuUpdateCar.addNewOption("4. Update car's engine.");
    
    do {
      menu.printMenu();
      choice = menu.getChoice();
      
      switch (choice) {
        case 1:
          brandBo.display();
          break;
        case 2:
          brandBo.add();
          carBo.setBrandList(brandBo.exportBrandList());
          break;
        case 3:
          id = Validate.getString (
            "Enter brand's id need to find: ", 
            "Invalidated ID", 
            IConstant.REGEX_BRAND_ID
          );
          
          index = brandBo.searchID(id);
          if(index == -1) {
            System.out.println("Not found!");
          } else {
            if(Helper.isContinue("Do you want to print the brand has found?")) {
              brandBo.displayOne(index);
            }
          }
          break;
        case 4:
          id = Validate.getString (
            "Enter brand's id need to update: ", 
            "Invalidated ID", 
            IConstant.REGEX_BRAND_ID
          );
          
          index = brandBo.searchID(id);
          
          if(index < 0) {
            System.out.println("Brand ID not exist!");
            break;
          }
          do {
            menuUpdateBrand.printMenu();
            choice = menuUpdateBrand.getChoice();

            switch (choice) {
              case 1:
                brandBo.update(index, IConstant.TYPE_NAME);
                break;
              case 2:
                brandBo.update(index, IConstant.TYPE_SOUND_BRAND);
                break;
              case 3:
                brandBo.update(index, IConstant.TYPE_PRICE);
                break;
            }
          } while (Helper.isContinue("Do you want to keep update this brand?"));
          carBo.setBrandList(brandBo.exportBrandList());
          break;
        case 5:
          if(brandBo.loadFromFile()) {
            carBo.setBrandList(brandBo.exportBrandList());
            System.out.println("Take data from file successful!");
          } else {
            System.out.println("An error occurred! Can't take data!");
          }
          break;
        case 6:
          if(brandBo.saveToFile()) {
            System.out.println("Save data to file successful!");
          } else {
            System.out.println("An error occurred! Can't save data!");
          }
          break;
        case 7:
          carBo.sort();
          carBo.display();
          break;
        case 8:
          carBo.add();
          break;
        case 9:
          index = carBo.search(IConstant.TYPE_ID);

          if(index < 0) {
            System.out.println("The car not exist!");
          } else {
            System.out.println("Here is the car you want to remove: ");
            carBo.displayOne(index);
            if (Helper.isContinue("Are you want to remove it?")) {
              carBo.remove(index);
            } else {
              System.out.println("Canceled remove car!");
            }
          }
          break;
        case 10:
          index = carBo.search(IConstant.TYPE_ID);
          
          if (index < 0) {
            System.out.println("The car isn't exist!");
            break;
          }
          
          do {
            menuUpdateCar.printMenu();
            choice = menuUpdateCar.getChoice();
            switch (choice) {
              case 1:
                carBo.update(IConstant.BRAND_OPTION, index);
                break;
              case 2:
                carBo.update(IConstant.TYPE_COLOR, index);
                break;
              case 3:
                carBo.update(IConstant.TYPE_FRAME, index);
                break;
              case 4:
                carBo.update(IConstant.TYPE_ENGINE, index);
                break;
            } 
          } while (Helper.isContinue("Do you want to keep update this car?"));
          break;
        case 11:
          if(carBo.loadFromFile()) {
            System.out.println("Take data from file successful!");
          } else {
            System.out.println("An error occurred! Can't take data!");
          }
          break;
        case 12:
          if(carBo.saveToFile()) {
            System.out.println("Save data to file successful!");
          } else {
            System.out.println("An error occurred! Can't save data!");
          }
          break;
      }
    } while (choice != 13);
  }
}
