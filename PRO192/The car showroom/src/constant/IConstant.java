/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author Admin
 */
public interface IConstant {

  String REGEX_FRAME_ID = "^[F]\\d{5}$";
  String REGEX_ENGINE_ID = "^[E]\\d{5}$";
  
  String REGEX_BRAND_NAME = "^[A-Za-z0-9 \\-\\(\\) ]+$";
  String REGEX_BRAND_ID = "^[A-Za-z0-9\\- ]+$";
  
  String REGEX_CAR_ID = "^[C]\\d{2}+$";
  String REGEX_CAR_NAME = "^[A-Za-z\\- ]+$";
  
  String REGEX_TEXT = "^[A-Za-z ]+$";
  String REGEX_FILE = "^.+\\.txt$";
  
  String REGEX_YES_NO = "^[yYnN]$";
  String YES = "y";

  String BRAND_OPTION = "Brand";
  String CAR_OPTION = "Car";
  
  String TYPE_NAME = "name";
  String TYPE_ID = "id";
  String TYPE_SOUND_BRAND = "sound brand";
  String TYPE_PRICE = "price";
  String TYPE_FRAME = "frame";
  String TYPE_ENGINE = "engine";
  String TYPE_COLOR = "color";
  String TYPE_BRAND = "brand";
}
