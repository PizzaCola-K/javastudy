package crm.cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        boolean[][] seatsState = new boolean[rows][seats];
        for (boolean[] row: seatsState) {
            Arrays.fill(row, false);
        }

        System.out.printf("%nCinema:%n");
        showSeats(rows, seats, seatsState);
        System.out.println();

        System.out.println("Enter a row number:");
        int ticketRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int ticketSeatNum = scanner.nextInt();

        int totalSeats = rows * seats;
        int ticketPrice;
        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else {
            if (ticketRow <= rows / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }

        System.out.printf("%nTicket price: $%d%n%n", ticketPrice);

        seatsState[ticketRow - 1][ticketSeatNum - 1] = true;

        System.out.printf("Cinema:%n");
        showSeats(rows, seats, seatsState);


    }

    public static void showSeats(int rows, int seats, boolean[][] seatsState) {
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                if (seatsState[i][j]) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }
}