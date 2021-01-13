package tictactoe;

import java.util.Arrays;
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
    private int turnCount;

    Main() {
        this.board = new char[9];
        Arrays.fill(this.board, ' ');
        turnCount = 0;
    }

    public char getBoard(int idx) {
        return board[idx];
    }

    public void setBoard(int idx, char c) {
        this.board[idx] = c;
        turnCount++;
    }

    public boolean isGameEnd() {
        char winner = findWinner();
        if (winner == ' ') {
            if (turnCount == 9) {
                showBoard();
                System.out.println("Draw");
                return true;
            } else {
                return false;
            }
        } else {
            showBoard();
            System.out.println(winner + " wins");
            return true;
        }
    }

    private char findWinner() {
        char winner = ' ';
        for (int[] idxs:matchIdx) {
            if (board[idxs[0]] == board[idxs[1]] && board[idxs[1]] == board[idxs[2]]) {
                winner = board[idxs[0]];
                return winner;
            }
        }
        return ' ';
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
        Main TicTacToe = new Main();

        boolean gameEnd = false;
        char turn = 'X';
        while (!gameEnd) {
            TicTacToe.showBoard();

            int row;
            int col;

            boolean inputEnd = false;
            while (!inputEnd) {
                System.out.print("Enter the coordinates: ");
                String input = scanner.nextLine();
                String[] inputs = input.split(" +");

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
                if (TicTacToe.getBoard(idx) != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    TicTacToe.setBoard(idx, turn);
                    if (turn == 'X') {
                        turn = 'O';
                    } else {
                        turn = 'X';
                    }
                    inputEnd = true;
                }
            }
            if (TicTacToe.isGameEnd()) {
                gameEnd = true;
            }

        }
        //TicTacToe.showBoard();
        //TicTacToe.analyzeState();
    }
}
