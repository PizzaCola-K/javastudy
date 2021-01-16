package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void printGrade(int bulls, int cows) {
        StringBuilder sb = new StringBuilder();
        sb.append("Grade: ");
        if (bulls == 0 && cows == 0) {
            sb.append("None.");
        } else if (bulls > 0 && cows == 0) {
            if (bulls == 1) {
                sb.append("1 bull.");
            } else {
                sb.append(bulls);
                sb.append(" bulls.");
            }
        } else if (bulls > 0 && cows > 0) {
            if (bulls == 1) {
                sb.append("1 bull and ");
            } else {
                sb.append(bulls);
                sb.append(" bulls and ");
            }

            if (cows == 1) {
                sb.append("1 cow.");
            } else {
                sb.append(cows);
                sb.append(" cows.");
            }
        } else {
            if (cows == 1) {
                sb.append("1 cow.");
            } else {
                sb.append(cows);
                sb.append(" cows.");
            }
        }
        System.out.println(sb);
    }

    public static char[] getUniqueDigitsCode(int length) {
        if (length <= 0 || length > 10) {
            return null;
        }
        char[] code = new char[length];
        int count = 0;
        Random random = new Random();

        boolean[] uniqueDigits = new boolean[10];
        while (count < length) {
            int digit = random.nextInt(10);
            if (!(count == 0 && digit == 0) && !uniqueDigits[digit]) {
                code[count] = (char) (digit + '0');
                uniqueDigits[digit] = true;
                count++;
            }
        }
        return code;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        char[] code = null;
        boolean exit = false;
        while (!exit) {
            System.out.println("Please, enter the secret code's length:");
            String input = scanner.next();
            if (input.matches("\\d+")) {
                length = Integer.parseInt(input);
                code = getUniqueDigitsCode(length);
                if (code == null) {
                    System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.%n", length);
                } else {
                    System.out.println("Okay, let's start a game!");
                    exit = true;
                }
            } else {
                System.out.println("Input is not a Number.");
            }
        }
        int turn = 1;

        // System.out.println(String.valueOf(code));
        exit = false;
        String pattern = "\\d{" + code.length + "}";
        while (!exit) {
            System.out.printf("Turn %d:%n", turn);
            String guessStr = scanner.next();
            if (guessStr.matches(pattern)) {
                int bulls = 0;
                int cows = 0;
                char[] guess = guessStr.toCharArray();
                for (int i = 0; i < code.length; i++) {
                    for (int j = 0; j < guess.length; j++) {
                        if (code[j] == guess[i]) {
                            if (i == j) {
                                bulls++;
                            } else {
                                cows++;
                            }
                            break;
                        }
                    }
                }

                printGrade(bulls, cows);
                if (bulls == code.length) {
                    System.out.println("Congratulations! You guessed the secret code.");
                    exit = true;
                }
                turn++;
            } else {
                System.out.println("Input Error. please input number.");
            }
        }
    }
}
