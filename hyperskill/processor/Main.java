package processor;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void sum() {
        int[] n = new int[2];
        int[] m = new int[2];

        int[][][] matrix = new int[3][][];

        for (int i = 0; i < 2; i++) {
            n[i] = scanner.nextInt();
            m[i] = scanner.nextInt();
            matrix[i] = new int[n[i]][m[i]];

            for (int ii = 0; ii < n[i]; ii++) {
                for (int jj = 0; jj < m[i]; jj++) {
                    matrix[i][ii][jj] = scanner.nextInt();
                }
            }
        }

        if (n[0] == n[1] && m[0] == m[1]) {
            int row = n[0];
            int col = m[0];
            matrix[2] = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[2][i][j] = matrix[0][i][j] + matrix[1][i][j];
                    System.out.printf("%d ",matrix[2][i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }

    public static void multiConstant() {
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int c = scanner.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%d ", c * matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        multiConstant();
    }
}
