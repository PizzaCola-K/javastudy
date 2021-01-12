package crm.cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private int rows;
    private int seats;
    private int numOfTickets;
    private int totalSeats;
    private int currentIncome;
    private int totalIncome;
    private boolean[][] seatsState;

    Cinema(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        seatsState = new boolean[rows][seats];
        for (boolean[] row: seatsState) {
            Arrays.fill(row, false);
        }
        this.totalSeats = rows * seats;
        if (totalSeats <= 60) {
            totalIncome = totalSeats * 10;
        } else {
            totalIncome = ((rows / 2) * 10 + (rows - rows / 2) * 8) * seats;
        }
        this.currentIncome = 0;
        this.numOfTickets = 0;
    }

    public int getRows() { return rows; }
    public int getSeats() { return seats; }

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
        if (seatsState[row - 1][col - 1]) {
            return false;
        } else {
            seatsState[row - 1][col - 1] = true;
            int ticketPrice = getTicketPrice(row);
            currentIncome += ticketPrice;
            numOfTickets++;
            return true;
        }
    }

    public int getTicketPrice(int row) {
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

    public void showStatistics() {
        System.out.printf("Number of purchased tickets: %d%n", numOfTickets);
        System.out.printf("Percentage: %.2f%%%n", numOfTickets * 100 / (double) totalSeats);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        Cinema cinema = new Cinema(rows, seats);

        boolean isExit = false;
        cli:
        while (!isExit) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int input = scanner.nextInt();

            System.out.println();
            switch (input) {
                case 0:
                    isExit = true;
                    break;
                case 1:
                    cinema.showCinema();
                    break;
                case 2:
                    buy:
                    while (true) {
                        System.out.println("Enter a row number:");
                        int row = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int col = scanner.nextInt();
                        if (1 <= row && row <= cinema.getRows() && 1 <= col && col <= cinema.getSeats()) {
                            if (cinema.buyTicket(row, col)) {
                                System.out.printf("%nTicket price: $%d%n", cinema.getTicketPrice(row));
                                break;
                            } else {
                                System.out.printf("%nThat ticket has already been purchased!%n%n");
                                continue buy;
                            }
                        } else {
                            System.out.printf("%nWrong input!%n%n");
                            continue buy;
                        }
                    }
                    break;
                case 3:
                    cinema.showStatistics();
            }
        }
    }
}