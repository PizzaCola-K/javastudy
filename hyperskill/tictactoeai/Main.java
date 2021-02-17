package tictactoe;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static TicTacToe ticTacToe;

    public static void main(String[] args) {
        // write your code here

        while (true) {
            Optional<String> input = enterTheCells();
            if (input.isEmpty()) {
                continue;
            }
            ticTacToe = TicTacToe.getInstance(input.get().toCharArray());
            if (ticTacToe == null) {
                continue;
            }
            break;
        }
        ticTacToe.show();

        while (true) {
            if (enterTheCoordinates()) {
                break;
            }
        }
        ticTacToe.show();
        ticTacToe.printWinner();
    }

    public static Optional<String> enterTheCells() {
        System.out.print("Enter the cells: ");
        String input = scanner.nextLine();
        Optional<String> result;
        if (input.matches("[XO_]{9}")) {
            result = Optional.of(input);
            return result;
        }
        return Optional.empty();
    }

    private static boolean checkInbound(int rowCol) {
        return 0 > rowCol || rowCol > 2;
    }

    public static boolean enterTheCoordinates() {
        System.out.print("Enter the coordinates: ");
        String input = scanner.nextLine();

        if (!input.matches("\\s*(\\d)\\s*(\\d)\\s*")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        Pattern digit = Pattern.compile("(\\d)\\s*(\\d)");
        Matcher inputMatcher = digit.matcher(input);
        inputMatcher.find();
        int row = Integer.parseInt(inputMatcher.group(1)) - 1;
        int col = Integer.parseInt(inputMatcher.group(2)) - 1;
        if (checkInbound(row) || checkInbound(col)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (ticTacToe.isOccupied(row, col)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        ticTacToe.set(row, col);
        return true;
    }
}
