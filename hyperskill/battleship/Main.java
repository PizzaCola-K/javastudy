package battleship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        Board[] playerBoard = new Board[2];

        playerBoard[0] = new Board(10,10);
        playerBoard[1] = new Board(10,10);

        int[] buf = new int[2];

        String[] shipNameArray = {
                "Aircraft Carrier",
                "Battleship",
                "Submarine",
                "Cruiser",
                "Destroyer"
        };
        int[] shipLengthArray = {5,4,3,3,2};

        for (int player = 0; player < 2; player++) {
            System.out.printf("Player %d, place your ships on the game field%n", player + 1);

            for (int i = 0; i < 5; i++) {
                System.out.println();
                playerBoard[player].show(Board.Mode.REVEAL);

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

                    if (playerBoard[player].setShipOnBoard(shipLength, shipNameArray[i], headRow, headCol, tailRow, tailCol)) {
                        inputCheck = true;
                    } else {
                        System.out.printf("%nError! You placed it too close to another one. Try again:%n%n");
                    }
                }
            }
            System.out.println();
            playerBoard[player].show(Board.Mode.REVEAL);

            promptEnterKey();
            System.out.println("...");
        }

        boolean gameEnd = false;
        boolean player1Turn = true;
        while (!gameEnd) {
            Board enemy = null;
            Board mine = null;

            if (player1Turn) {
                enemy = playerBoard[1];
                mine = playerBoard[0];
            } else {
                enemy = playerBoard[0];
                mine = playerBoard[1];
            }

            System.out.println();
            enemy.show(Board.Mode.FOG);
            System.out.println("---------------------");
            mine.show(Board.Mode.REVEAL);

            System.out.printf("%nPlayer %d, it's your turn:%n%n", (player1Turn)? 1 : 2);

            boolean inputCheck = false;
            int targetRow = 0;
            int targetCol = 0;
            while (!inputCheck) {
                String target = scanner.next();
                System.out.println();
                parse(target, buf);
                targetRow = buf[0];
                targetCol = buf[1];

                if (!enemy.checkRange(targetRow, targetCol)) {
                    System.out.printf("%nError! You entered the wrong coordinates! Try again:%n");
                    continue;
                }
                inputCheck = true;
            }

            int isHit = enemy.shoot(targetRow, targetCol);

            System.out.println();
            if (isHit == 1) {
                System.out.println("You hit a ship!");
            } else if (isHit == 2) {
                System.out.println("You sank a ship! Specify a new target:");
            } else if (isHit == 3) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                gameEnd = true;
                continue;
            } else {
                System.out.println("You missed.");
            }

            promptEnterKey();
            System.out.println("...");

            player1Turn = !player1Turn;
        }
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
    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Board {
    private char[][] board;
    private char[][] fogBoard;
    private ArrayList<Ship> ships;

    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = mkBoard(rows, cols);
        this.fogBoard = mkBoard(rows, cols);
        this.ships = new ArrayList<>();
    }

    public enum Mode {
        FOG,
        REVEAL
    }

    public void show(Mode mode) {
        char[][] board = null;
        switch (mode) {
            case REVEAL:
                board = this.board;
                break;
            case FOG:
                board = this.fogBoard;
                break;
        }

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

    public boolean checkRange(int row, int col) {
        if (1 <= row && row <= rows && 1 <= col && col <= cols) {
            return true;
        } else {
            return false;
        }
    }

    public int shoot(int row, int col) {
        // return 0 : MISS
        // return 1 : HIT
        // return 2 : SANK
        // return 3 : GAME END
        if (board[row][col * 2] == 'O') {
            boolean isSank = false;
            for (Ship ship : ships) {
                if (ship.isHit(row, col)) {
                    ship.hitCount++;
                    if (ship.isSank()) {
                        isSank = true;
                    }
                    break;
                }
            }

            board[row][col * 2] = 'X';
            fogBoard[row][col * 2] = 'X';
            if (isSank) {
                int sankCount = 0;
                for (Ship ship : ships) {
                    if (ship.isSank()) {
                        sankCount++;
                    }
                }
                if (sankCount == ships.size()) {
                    return 3;
                } else {
                    return 2;
                }
            } else {
                return 1;
            }
        } else if (board[row][col * 2] == 'X') {
            return 1;
        } else {
            board[row][col * 2] = 'M';
            fogBoard[row][col * 2] = 'M';
            return 0;
        }
    }

    public boolean setShipOnBoard(int length, String name, int headRow, int headCol, int tailRow, int tailCol) {
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
                if (board[i][j * 2] != '~') {
                    return false;
                }
            }
        }

        Ship ship = new Ship(length, name, headRow, headCol, tailRow, tailCol);
        this.ships.add(ship);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                board[i][j * 2] = 'O';
            }
        }
        return true;
    }

    private char[][] mkBoard(int rows, int cols) {
        char[][] board = new char[rows + 2][cols * 2 + 4];
        for (char[] row : board) {
            for (int i = 0; i < row.length; i += 2) {
                row[i] = '~';
                row[i + 1] = ' ';
            }
        }
        return board;
    }

    class Ship {

        private String name;
        private int length;
        private Point[] body;
        private int hitCount;

        public Ship(int length, String name, int headRow, int headCol, int tailRow, int tailCol) {
            this.length = length;
            this.name = name;
            this.hitCount = 0;

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

            this.body = new Point[length];
            int idx = 0;
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    this.body[idx] = new Point(i, j);
                    idx++;
                }
            }
        }

        public boolean isHit(int row, int col) {
            for (Point p : body) {
                if (p.match(row, col)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isSank() {
            return length <= hitCount;
        }
    }
    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean match(int row, int col) {
            return this.row == row && this.col == col;
        }
    }
}