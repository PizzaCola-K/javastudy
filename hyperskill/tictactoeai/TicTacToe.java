package tictactoe;

public class TicTacToe {
    private final char[] board;
    private final int ROW = 3;
    private final int COL = 3;
    private Turn turn;

    private TicTacToe(char[] board, Turn turn) {
        initBoard(board);
        this.board = board;
        this.turn = turn;
    }

    public void show() {
        String horizontalLine = "---------";
        System.out.println(horizontalLine);
        for (int row = 0; row < ROW; row++) {
            showRow(row);
        }
        System.out.println(horizontalLine);
    }

    private void showRow(int row) {
        System.out.print("| ");
        for (int col = 0; col < COL; col++) {
            System.out.printf("%c ", getBoardItem(row, col));
        }
        System.out.println("|");
    }

    private char getBoardItem(int row, int col) {
        return board[COL * row + col];
    }

    private void initBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '_') {
                board[i] = ' ';
            }
        }
    }

    public static TicTacToe getInstance(char[] board) {
        int xoDiff = 0;
        for (char item : board) {
            if (item == 'X') {
                xoDiff++;
            }
            if (item == 'O') {
                xoDiff--;
            }
        }
        if (xoDiff == 1) {
            return new TicTacToe(board, Turn.O);
        }
        if (xoDiff == 0) {
            return new TicTacToe(board, Turn.X);
        }
        return null;
    }

    public boolean isOccupied(int row, int col) {
        char item = getBoardItem(row, col);
        return item == 'O' || item == 'X';
    }

    public void set(int row, int col) {
        if (!isOccupied(row, col)) {
            board[COL * row + col] = this.turn.getRepresentation();
            this.turn = this.turn.next();
        }
    }

    public void printWinner() {
        if (isXWin()) {
            System.out.println("X wins");
            return;
        }
        if (isOWin()) {
            System.out.println("O wins");
            return;
        }
        if (isBoardFull()) {
            System.out.println("Draw");
            return;
        }
        System.out.println("Game not finished");
    }

    private boolean isBoardFull() {
        for (char item : board) {
            if (item == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean isXWin() {
        return isWin('X');
    }

    public boolean isOWin() {
        return isWin('O');
    }

    private boolean isWin(char player) {
        if (board[0] == board[1] && board[1] == board[2]) {
            return board[0] == player;
        }
        if (board[3] == board[4] && board[4] == board[5]) {
            return board[3] == player;
        }
        if (board[6] == board[7] && board[7] == board[8]) {
            return board[6] == player;
        }
        if (board[0] == board[3] && board[3] == board[6]) {
            return board[0] == player;
        }
        if (board[1] == board[4] && board[4] == board[7]) {
            return board[1] == player;
        }
        if (board[2] == board[5] && board[5] == board[8]) {
            return board[2] == player;
        }
        if (board[0] == board[4] && board[4] == board[8]) {
            return board[0] == player;
        }
        if (board[2] == board[4] && board[4] == board[6]) {
            return board[2] == player;
        }
        return false;
    }

    enum Turn {
        X('X'),
        O('O');

        public final char representation;

        Turn(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }

        public Turn next() {
            if (this == Turn.X) {
                return Turn.O;
            }
            return Turn.X;
        }
    }
}
