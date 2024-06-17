/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.IConstant;
import utils.Validate;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
		String firstString = Validate.getString("Enter first string: ", "Invalidated string!", IConstant.REGEX_TEXT);
		String secondString = Validate.getString("Enter first string: ", "Invalidated string!", IConstant.REGEX_TEXT);
		
		System.out.println("Checking strings for anagram:");
		System.out.println("String 1: " + firstString);
		System.out.println("String 2: " + secondString);
		
		if(checkAnagram(firstString, secondString)){
			System.out.println("They are anagrams.");
		}
		else {
			System.out.println("They are not anagrams.");
		}

	}
	
	static boolean checkAnagram(String string1, String string2){
		
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();
		
		StringBuilder sb = new StringBuilder(string2);
		
		for(int i = 0; i < string1.length(); i++){
			int index = sb.indexOf(String.valueOf(string1.charAt(i))); //Find index foreach char in the first string
		
			if(index != -1){
				sb.deleteCharAt(index);
			}
			else {
				return false;
			}
		}
		
		return true;
	}
}
