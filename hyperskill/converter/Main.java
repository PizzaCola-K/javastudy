package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.matches("\\d+")) {
            int num = Integer.parseInt(input);
            System.out.println(num % 8);
        }
    }
}
