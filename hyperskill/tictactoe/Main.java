package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        char[] chars = input.toCharArray();

        System.out.println("---------");
        System.out.println("| " + chars[0] + " " + chars[1] + " " + chars[2] + " |");
        System.out.println("| " + chars[3] + " " + chars[4] + " " + chars[5] + " |");
        System.out.println("| " + chars[6] + " " + chars[7] + " " + chars[8] + " |");
        System.out.println("---------");
    }
}
