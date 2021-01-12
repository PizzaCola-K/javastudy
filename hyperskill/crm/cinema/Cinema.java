package crm.cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        int totalSeats = rows * seats;

        int incomes = 0;
        if (totalSeats <= 60) {
            incomes = totalSeats * 10;
        } else {
            incomes = ((rows / 2) * 10 + (rows - rows / 2) * 8) * seats;
        }
        System.out.println("Total income:");
        System.out.println("$"+incomes);
    }
}