package util;

import java.util.Scanner;

public class Validate {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Validate() {}

    public static String getString(String messageInfo, String messageError, final String REGEX) {
        do {
            System.out.print(messageInfo);
            String string = SCANNER.nextLine();
            if (string.matches(REGEX)) {
                return string.trim();
            }
            System.out.println(messageError);
        } while (true);
    }

    public static int getInt(String messageInfo, String messageErrorOutOfRange, String messageErrorInvalidNumber, int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
