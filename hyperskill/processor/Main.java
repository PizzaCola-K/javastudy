package processor;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void sum() {
        int[][] rowCol = new int[2][];
        double[][] matrix = new double[2][];
        for (int matNum = 0; matNum < 2; matNum++) {
            String nth = "first";
            if (matNum == 1) {
                nth = "second";
            }
            System.out.printf("Enter size of %s matrix: ", nth);

            int[] size = getSize();
            if (size != null) {
                rowCol[matNum] = size;
            } else {
                System.out.println("The operation cannot be performed.");
                return;
            }
            System.out.printf("Enter %s matrix:%n", nth);

            matrix[matNum] = getMatrix(rowCol[matNum][0], rowCol[matNum][1]);

        }

        if (rowCol[0][0] != rowCol[1][0] || rowCol[0][1] != rowCol[1][1]) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        int len = matrix[0].length;
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            result[i] = matrix[0][i] + matrix[1][i];
        }

        System.out.println("The result is:");
        showMatrix(result, rowCol[0][1]);
        System.out.println();
    }

    public static void multiConstant() {
        System.out.print("Enter size of matrix: ");
        int[] rowCol = getSize();
        if (rowCol == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        System.out.println("Enter matrix:");
        double[] matrix = getMatrix(rowCol[0], rowCol[1]);
        System.out.print("Enter constant: ");

        double constant = scanner.nextDouble();
        scanner.nextLine();
        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[i] * constant;
        }

        System.out.println("The result is:");
        showMatrix(result, rowCol[1]);
        System.out.println();
    }

    public static void multMatirx() {
        int[][] rowCol = new int[2][];
        double[][] matrix = new double[2][];
        for (int matNum = 0; matNum < 2; matNum++) {
            String nth = "first";
            if (matNum == 1) {
                nth = "second";
            }
            System.out.printf("Enter size of %s matrix: ", nth);

            int[] size = getSize();
            if (size != null) {
                rowCol[matNum] = size;
            } else {
                System.out.println("The operation cannot be performed.");
                return;
            }
            System.out.printf("Enter %s matrix:%n", nth);

            matrix[matNum] = getMatrix(rowCol[matNum][0], rowCol[matNum][1]);
        }

        if (rowCol[0][1] != rowCol[1][0]) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        int len = rowCol[0][0] * rowCol[1][1];
        double[] result = new double[len];
        for (int i = 0; i < rowCol[0][0]; i++) {
            for (int j = 0; j < rowCol[1][1]; j++) {
                for (int k = 0; k < rowCol[0][1]; k++) {
                    result[i * rowCol[1][1] + j] += matrix[0][i * rowCol[0][1] + k]
                            * matrix[1][k * rowCol[1][1] + j];
                }
            }
        }
        System.out.println("The result is:");
        showMatrix(result, rowCol[1][1]);
        System.out.println();
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");
            System.out.print("your choice: ");
            String input = scanner.nextLine();
            if (!input.matches("[0123]")) {
                System.out.println("Error");
                continue;
            }
            switch (input) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    sum();
                    break;
                case "2":
                    multiConstant();
                    break;
                case "3":
                    multMatirx();
                    break;
                default:
                    break;
            }

        }

    }

    public static double[] getMatrix(int row, int col) {
        int len = row * col;
        double[] matrix = new double[len];
        for (int i = 0; i < len; i++) {
            matrix[i] = scanner.nextDouble();
        }
        scanner.nextLine();
        return matrix;
    }

    public static int[] getSize() {
        String input = scanner.nextLine();

        if (input.matches("\\d+\\s\\d+")) {
            String[] inputs = input.split("\\s");
            int[] size = new int[2];
            for (int i = 0; i < 2; i++) {
                size[i] = Integer.parseInt(inputs[i]);
            }
            return size;
        } else {
            return null;
        }
    }

    public static void showMatrix(double[] matrix, int col) {
        int len = matrix.length;
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < len; i++) {
            System.out.print(df.format(matrix[i]) + " ");
            if (i % col == col - 1) {
                System.out.println();
            }
        }
    }
}
