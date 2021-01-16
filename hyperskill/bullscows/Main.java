package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void bullscows() {
        int num = new Random().ints(1, 1000,10000)
                .findFirst().getAsInt();

        char[] code = new char[4];
        for (int i = 3; i >= 0; i--) {
            code[i] = (char) (num % 10 + '0');
            num /= 10;
        }

        Scanner scanner = new Scanner(System.in);

        String guessStr = scanner.next();
        int bulls = 0;
        int cows = 0;
        if (guessStr.matches("\\d{" + code.length + "}")) {
            char[] guess = guessStr.toCharArray();

            for (int i = 0; i < code.length; i++) {
                for (int j = 0; j < guess.length; j++) {
                    if (code[i] == guess[j]) {
                        if (i == j) {
                            bulls++;
                        } else {
                            cows++;
                        }
                        break;
                    }
                }
            }

            System.out.print("Grade: ");
            if (bulls == 0 && cows == 0) {
                System.out.print("None.");
            } else if (bulls > 0 && cows == 0) {
                System.out.printf("%d bull(s).", bulls);
            } else if (bulls > 0 && cows > 0) {
                System.out.printf("%d bull(s) and %d cow(s).", bulls, cows);
            } else {
                System.out.printf("%d cows(s).", cows);
            }
            System.out.printf(" The secret code is %s.%n", String.valueOf(code));
        } else {
            System.out.println("wrong input");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] uniqueDigits = new boolean[10];

        String input = scanner.next();
        int length;
        if (input.matches("\\d+")) {
            length = Integer.parseInt(input);
            if (0 <= length && length <= 10) {
                char[] code = new char[length];
                long pseudoRandomNumber = System.nanoTime();
                int count = 0;
                while (count < length) {
                    int digit = (int) (pseudoRandomNumber % 10);
                    if (!(count == 0 && digit == 0) && !uniqueDigits[digit]) {
                        code[count] = (char) (digit + '0');
                        uniqueDigits[digit] = true;
                        count++;
                    }
                    pseudoRandomNumber /= 10;
                    if (pseudoRandomNumber == 0) {
                        pseudoRandomNumber = System.nanoTime();
                    }
                }
                System.out.printf("The random secret number is %s.%n", String.valueOf(code));
            } else {
                System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.%n", length);
            }
        }


    }
}
