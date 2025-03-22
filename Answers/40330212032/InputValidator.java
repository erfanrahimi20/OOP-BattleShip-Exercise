import java.util.Scanner;
public class InputValidator {
    public static boolean isValidCoordinate(String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');
    }

    public static int[] convertCoordinate(String input) {
        int col = input.charAt(0) - 'A';
        int row = input.charAt(1) - '0';
        return new int[]{row, col};
    }

    public static boolean isValidInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
