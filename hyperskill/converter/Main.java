package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.next();
        String radixStr = scanner.next();

        long number = Long.parseLong(numberStr);

        switch (radixStr) {
            case "2":
                System.out.println("0b" + Long.toString(number, 2));
                break;
            case "8":
                System.out.println("0" + Long.toString(number, 8));
                break;
            case "16":
                System.out.println("0x" + Long.toString(number, 16));
                break;
            default:

        }
    }
}
