package util;

import java.util.Scanner;

public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        int value = 0;

        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Value must be > 0");
            } catch (NumberFormatException e) {
                System.err.println("Please enter again");
            }
        }
    }

    public static String getAString() {
        String id;
        while (true) {
            id = scanner.nextLine().trim().toUpperCase();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println("String can not empty");
            } else {
                return id;
            }
        }
    }

    public static boolean getBoolean() {
        boolean value = false;

        while (true) {
            try {
                value = Boolean.parseBoolean(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.err.println("Please enter again");
            }
        }
    }
}
