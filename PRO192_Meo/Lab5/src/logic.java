/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class logic {

    public static boolean checkAnagram(String string1, String string2) {

        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        StringBuilder sb = new StringBuilder(string2);

        for (int i = 0; i < string1.length(); i++) {
            int index = sb.indexOf(String.valueOf(string1.charAt(i)));

            if (index != -1) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return true;
    }
}
