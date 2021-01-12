package crm.cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private int rows;
    private int seats;
    private boolean[][] seatsState;

    Cinema(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        seatsState = new boolean[rows][seats];
        for (boolean[] row: seatsState) {
            Arrays.fill(row, false);
        }
    }

    public void showCinema() {
        System.out.println("Cinema:");
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

    public boolean buyTicket(int row, int col) {
        try {
            if (seatsState[row - 1][col - 1]) {
                return false;
            } else {
                seatsState[row - 1][col - 1] = true;
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getTicketPrice(int row) {
        int totalSeats = this.rows * this.seats;
        if (totalSeats <= 60) {
            return 10;
        } else {
            if (row <= this.rows / 2) {
                return 10;
            } else {
                return 8;
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        Cinema cinema = new Cinema(rows, seats);

        cli:
        while (true) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");

            int input = scanner.nextInt();

            System.out.println();
            switch (input) {
                case 0:
                    break cli;
                case 1:
                    cinema.showCinema();
                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    int row = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int col = scanner.nextInt();
                    cinema.buyTicket(row, col);
                    System.out.printf("Ticket price: $%d%n", cinema.getTicketPrice(row));

            }
        }
    }



}