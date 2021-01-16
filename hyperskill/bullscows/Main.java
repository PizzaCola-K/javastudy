package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String makePattern(int length, int symbols) {
        StringBuilder sb = new StringBuilder();
        sb.append("[0-");
        if (symbols <= 10) {
            sb.append(symbols - 1);
        } else {
            sb.append("9a-");
            sb.append((char)(symbols - 11 + 'a'));
        }
        sb.append("]{");
        sb.append(length);
        sb.append("}");
        return sb.toString();
    }

    public static void printPrepared(int length, int symbols) {
        System.out.print("The secret is prepared: ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        sb.append(" ");
        System.out.print(sb);
        if (symbols <= 10) {
            if (symbols == 1) {
                System.out.print("(0).");
            } else {
                System.out.printf("(0-%d).", symbols - 1);
            }
        } else {
            System.out.print("(0-9, ");
            if (symbols == 11) {
                System.out.print("a).");
            } else {
                System.out.printf("a-%c).", (char) (symbols - 11 + 'a'));
            }
        }
        System.out.println();
    }

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

    public static char[] getUniqueDigitsCode(int length, int symbols) {
        if (symbols > 36) {
            return null;
        }
        if (length <= 0 || length > symbols) {
            return null;
        }
        char[] code = new char[length];
        int count = 0;
        Random random = new Random();

        boolean[] uniqueDigits = new boolean[symbols];
        while (count < length) {
            int digit = random.nextInt(symbols);
            if (!(count == 0 && digit == 0) && !uniqueDigits[digit]) {
                if (digit < 10) {
                    code[count] = (char) (digit + '0');
                } else {
                    code[count] = (char) (digit - 10 + 'a');
                }
                uniqueDigits[digit] = true;
                count++;
            }
        }
        return code;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        int symbols;
        char[] code = null;
        boolean exit = false;

        String pattern = null;
        while (!exit) {
            System.out.println("Input the length of the secret code:");
            String input = scanner.next();
            if (input.matches("\\d+")) {
                length = Integer.parseInt(input);
                System.out.println("Input the number of possible symbols in the code:");
                input = scanner.next();
                if(input.matches("\\d+")) {
                    symbols = Integer.parseInt(input);
                    if (length == 0) {
                        System.out.println("Error: length must be greater than 0");
                        System.exit(-1);
                    } else if (length > symbols) {
                        System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.%n", length, symbols);
                        System.exit(-1);
                    } else if (symbols > 36) {
                        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                        System.exit(-1);
                    }
                    code = getUniqueDigitsCode(length, symbols);
                    exit = true;
                    printPrepared(length, symbols);
                    System.out.println("Okay, let's start a game!");
                    pattern = makePattern(length, symbols);
                } else {
                    System.out.println("Input is not a Number.");
                }
            } else {
                System.out.printf("Error: \"%s\" isn't a valid number.", input);
                System.exit(-1);
            }
        }

        int turn = 1;

        // System.out.println(String.valueOf(code));
        exit = false;
        // System.out.println(pattern);

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
