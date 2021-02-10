package processor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("your choice: ");
            String input = scanner.nextLine();
            if (!input.matches("[0123456]")) {
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
                case "4":
                    transposeMatrix();
                    break;
                case "5":
                    determinantMatrix();
                    break;
                case "6":
                    inverseMatrix();
                    break;
                default:
                    break;
            }

        }

    }

    private static void inverseMatrix() {
        System.out.print("Enter matrix size: ");
        int[] rowCol = getSize();
        if (rowCol == null || rowCol[0] != rowCol[1]) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        System.out.println("Enter matrix:");
        double[] matrix = getMatrix(rowCol[0], rowCol[1]);
        List<Double> listMatrix = Arrays.stream(matrix).boxed().collect(Collectors.toList());
        double det = determinant(listMatrix, rowCol[0], rowCol[1]);
        if (det == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return;
        }
        double[] cofactor = new double[rowCol[0] * rowCol[1]];
        for (int i = 0; i < rowCol[0]; i++) {
            for (int j = 0; j < rowCol[1]; j++) {
                int coef = ((i + j) % 2 == 0) ? 1 : -1;
                List<Double> minor = new ArrayList<>();

                for (int ii = 0; ii < rowCol[0]; ii++) {
                    for (int jj = 0; jj < rowCol[1]; jj++) {
                        if (ii != i && jj != j) {
                            minor.add(matrix[ii * rowCol[1] + jj]);
                        }
                    }
                }
                int n = rowCol[0] - 1;
                cofactor[i * rowCol[1] + j] = coef * determinant(minor, n, n);
            }
        }
        double[] result = transposeMain(cofactor, rowCol[0], rowCol[1]);
        for (int i = 0; i < result.length; i++) {
            result[i] /= det;
        }
        showMatrix(result, rowCol[1]);
    }

    private static void determinantMatrix() {
        System.out.print("Enter matrix size: ");
        int[] rowCol = getSize();
        if (rowCol == null || rowCol[0] != rowCol[1]) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        System.out.println("Enter matrix:");
        double[] matrix = getMatrix(rowCol[0], rowCol[1]);
        List<Double> listMatrix = Arrays.stream(matrix).boxed().collect(Collectors.toList());
        double det = determinant(listMatrix, rowCol[0], rowCol[1]);
        System.out.println("The result is:");
        System.out.println(det);
    }

    private static double determinant(List<Double> matrix, int row, int col) {
        if (row == 2) {
            return matrix.get(0) * matrix.get(3) - matrix.get(1) * matrix.get(2);
        }
        double result = 0;
        int coff = 1;
        for (int j = 0; j < col; j++) {
            List<Double> subMatrix = new ArrayList<>();
            for (int ii = 1; ii < row; ii++) {
                for (int jj = 0; jj < col; jj++) {
                    if (jj != j) {
                        subMatrix.add(matrix.get(ii * col + jj));
                    }
                }
            }
            result += matrix.get(j) * coff * determinant(subMatrix, row - 1, col - 1);
            coff *= -1;
        }
        return result;
    }

    private static void transposeMatrix() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.println("Your choice: ");
        String mode = scanner.nextLine();

        if (!mode.matches("[1234]")) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        System.out.print("Enter matrix size: ");
        int[] rowCol = getSize();
        if (rowCol == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        System.out.println("Enter matrix: ");

        double[] matrix = getMatrix(rowCol[0], rowCol[1]);
        double[] result = null;

        switch (mode) {
            case "1":
                result = transposeMain(matrix, rowCol[0], rowCol[1]);
                showMatrix(result, rowCol[0]);
                break;
            case "2":
                result = transposeSide(matrix, rowCol[0], rowCol[1]);
                showMatrix(result, rowCol[0]);
                break;
            case "3":
                result = transposeVertical(matrix, rowCol[0], rowCol[1]);
                showMatrix(result, rowCol[1]);
                break;
            case "4":
                result = transposeHorizontal(matrix, rowCol[0], rowCol[1]);
                showMatrix(result, rowCol[1]);
                break;
        }


    }

    private static double[] transposeHorizontal(double[] matrix, int row, int col) {
        double[] result = new double[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[(row - 1 - i) * col + j] = matrix[i * col + j];
            }
        }
        return result;
    }

    private static double[] transposeVertical(double[] matrix, int row, int col) {
        double[] result = new double[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i * col + col - 1 - j] = matrix[i * col + j];
            }
        }
        return result;
    }

    private static double[] transposeSide(double[] matrix, int row, int col) {
        double[] result = new double[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[(col - 1 - j) * row + row - 1 - i] = matrix[i * col + j];
            }
        }
        return result;
    }

    private static double[] transposeMain(double[] matrix, int row, int col) {
        double[] result = new double[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j * row + i] = matrix[i * col + j];
            }
        }
        return result;
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
        DecimalFormat df = new DecimalFormat("#.######");
        for (int i = 0; i < len; i++) {
            System.out.print(df.format(matrix[i]) + " ");
            if (i % col == col - 1) {
                System.out.println();
            }
        }
    }
}
