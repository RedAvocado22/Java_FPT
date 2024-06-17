/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringshit;

/**
 *
 * @author FPT Shop
 */
public class StringShit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StandardizeName("wall123@");
    }

    public static void Vowels_Consonats(String str) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                // Kiểm tra xem ký tự có phải là nguyên âm hay không
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Số lượng nguyên âm: " + vowels);
        System.out.println("Số lượng phụ âm: " + consonants);
    }

    public static void isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                System.out.println("False");
                return;
            }
            left++;
            right--;
        }
        System.out.println("True");
    }

    public static void FindWord(String string, String toFind) {
        int position = 0;
        int count = 0;
        while ((position = string.indexOf(toFind, position)) != -1) {
            System.out.println("Vị trí của \"" + toFind + "\" là: " + position);
            position = position + 1;
            count++;
        }
        System.out.println("Số lần \"" + toFind + "\" xuất hiện là: " + count);
    }

    public static void StandardizeName(String s) {
        s = s.replaceAll("[^a-zA-Z0-9 ]", " ");
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase());
                result.append(word.substring(1).toLowerCase());
                result.append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
    
    public static void WordsinStringPalindrome(String str) {
        String[] words = str.split("\\s+");
        for (String word : words) {
            isPalindrome(word);
        }
    }
    
    public static void WordsinString(String str) {
        
    }
}
