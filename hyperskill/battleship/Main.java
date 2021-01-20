package battleship;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(10, 10);

        int[] buf = new int[2];

        String[] shipNameArray = {
                "Aircraft Carrier",
                "Battleship",
                "Submarine",
                "Cruiser",
                "Destroyer"
        };
        int[] shipLengthArray = {5,4,3,3,2};
        board.show();
        for (int i = 0; i < 5; i++) {
            System.out.printf("%nEnter the coordinates of the %s (%d cells):%n%n", shipNameArray[i], shipLengthArray[i]);

            int headRow;
            int headCol;
            int tailRow;
            int tailCol;

            boolean inputCheck = false;
            while (!inputCheck) {
                String head = scanner.next();
                String tail = scanner.next();

                parse(head, buf);
                headRow = buf[0];
                headCol = buf[1];

                parse(tail, buf);
                tailRow = buf[0];
                tailCol = buf[1];

                int shipLength = getLength(headRow, headCol, tailRow, tailCol);

                if (shipLength == shipLengthArray[i]) {

                } else if (shipLength == 0){
                    System.out.printf("%nError! Wrong ship location! Try again:%n%n");
                    continue;
                } else {
                    System.out.printf("%nError! Wrong length of the %s! Try again:%n%n", shipNameArray[i]);
                    continue;
                }

                if (setShipOnBoard(headRow, headCol, tailRow, tailCol, board)) {
                    inputCheck = true;
                } else {
                    System.out.printf("%nError! You placed it too close to another one. Try again:%n%n");
                }
            }
            System.out.println();
            board.show();
        }
    }

    public static boolean setShipOnBoard(int headRow, int headCol, int tailRow, int tailCol, Board board) {
        int startRow;
        int endRow;
        int startCol;
        int endCol;
        if (headRow > tailRow) {
            startRow = tailRow;
            endRow = headRow;
        } else {
            startRow = headRow;
            endRow = tailRow;
        }
        if (headCol > tailCol) {
            startCol = tailCol;
            endCol = headCol;
        } else {
            startCol = headCol;
            endCol = tailCol;
        }

        for (int i = startRow - 1; i <= endRow + 1; i++) {
            for (int j = startCol - 1; j <= endCol + 1; j++) {
                if (board.board[i][j * 2] != '~') {
                    return false;
                }
            }
        }

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                board.board[i][j * 2] = 'O';
            }
        }
        return true;
    }

    public static int getLength(int headRow, int headCol, int tailRow, int tailCol) {
        int shipLength = 0;
        if (headRow == tailRow) {
            shipLength = Math.abs(headCol - tailCol) + 1;
        } else if (headCol == tailCol) {
            shipLength = Math.abs(headRow - tailRow) + 1;
        }
        return shipLength;
    }

    public static void parse(String position, int[] result) {
        final String PATTERN = "([A-Z])(\\d+)";
        if (result.length < 2) {
            result[0] = -1;
            result[1] = -1;
            return;
        }
        if (position.matches(PATTERN)) {
            Pattern p = Pattern.compile(PATTERN);
            Matcher m = p.matcher(position);

            m.find();
            String row = m.group(1);
            String col = m.group(2);

            result[0] = row.charAt(0) - 'A' + 1;
            result[1] = Integer.parseInt(col);
        } else {
            result[0] = -1;
            result[1] = -1;
        }
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class AircraftCarrier {
    Point head;
    Point tail;

    private AircraftCarrier(Point head, Point tail) {
        this.head = head;
        this.tail = tail;
    }

}

class Board {
    char[][] board;

    public Board(int rows, int cols) {
        board = new char[rows + 2][cols * 2 + 4];
        for (char[] row : board) {
            for (int i = 0; i < row.length; i += 2) {
                row[i] = '~';
                row[i + 1] = ' ';
            }
        }
    }

    public void show() {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        char rowIdx = 'A';
        for (int i = 1; i < board.length - 1; i++) {
            System.out.print(rowIdx + " ");
            for (int j = 2; j < board[i].length - 2; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
            rowIdx++;
        }
    }
}