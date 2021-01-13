package tictactoe;

import java.util.Scanner;

public class Main {
    private final int[][] matchIdx = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private char[] board;

    Main(char[] board) {
        this.board = board;
    }

    public char getBoard(int idx) {
        return board[idx];
    }

    public void setBoard(int idx, char c) {
        this.board[idx] = c;
    }

    public void analyzeState() {
        int countX = 0;
        int countO = 0;
        int countBlank = 0;

        for (char c : board) {
            switch (c) {
                case 'O':
                    countO++;
                    break;
                case 'X':
                    countX++;
                    break;
                case '_':
                    countBlank++;
            }
        }
        if (countO - countX == 0 || countO - countX == 1 || countO - countX == -1) {
            char winner = findWinner();
            if (winner == 'O' || winner == 'X') {
                System.out.println(winner + " wins");
            } else if (winner == 'x') {
                System.out.println("Impossible");
            } else if (countBlank == 0){
                System.out.println("Draw");
            } else {
                System.out.println("Game not finished");
            }
        } else {
            System.out.println("Impossible");
        }
    }

    private char findWinner() {
        int winnerCount = 0;
        char winner = '_';
        for (int[] idxs:matchIdx) {
            if (board[idxs[0]] == board[idxs[1]] && board[idxs[1]] == board[idxs[2]]) {
                winner = board[idxs[0]];
                winnerCount++;
                if (winnerCount > 1) {
                    return 'x';
                }
            }
        }
        return winner;
    }


    public void showBoard() {
        System.out.println("---------");
        System.out.println("| " + board[0] + " " + board[1] + " " + board[2] + " |");
        System.out.println("| " + board[3] + " " + board[4] + " " + board[5] + " |");
        System.out.println("| " + board[6] + " " + board[7] + " " + board[8] + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        char[] chars = input.toCharArray();

        Main TicTacToe = new Main(chars);

        TicTacToe.showBoard();
        boolean end = false;
        while (!end) {
            System.out.print("Enter the coordinates: ");
            input = scanner.nextLine();
            String[] inputs = input.split(" +");

            int row;
            int col;
            try {
                row = Integer.parseInt(inputs[0]);
                col = Integer.parseInt(inputs[1]);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            row -= 1;
            col -= 1;

            int idx = row * 3 + col;
            if (TicTacToe.getBoard(idx) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                TicTacToe.setBoard(idx, 'X');
                end = true;
            }


        }
        TicTacToe.showBoard();
        //TicTacToe.analyzeState();
    }
}
