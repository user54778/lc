package backtracking;

import java.util.*;

public class NQueens {
    private final List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // backtrack call
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, n);
        return solutions;
    }

    /**
     * Helper function to get solutions in the correct output formate
     * @param state state of the board
     * @return list of row states
     */
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (char[] chars : state) {
            String currRow = new String(chars);
            board.add(currRow);
        }
        return board;
    }

    /**
     * Main method to solve the N-Queens puzzle.
     * We maintain 3 HashSets to track the three positions: col, posDiag, negDiag to only place
     * a valid queen.
     * @param row row we are on
     * @param colSet column set
     * @param posSet diag going in the top right direction
     * @param negSet diag going in the bot right direction
     * @param state board state
     */
    private void backtrack(int row, Set<Integer> colSet, Set<Integer> posSet, Set<Integer> negSet,
                           char[][] state, int n) {
        // base case
        if (row == n) {
            solutions.add(createBoard(state));  // update our current board
            return;
        }

        for (int col = 0; col < n; col++) {
            int posDiagonal = row + col;
            int negDiagonal = row - col;
            // check if queen isn't placeable; skip this current position
            if (colSet.contains(col) || posSet.contains(posDiagonal) || negSet.contains(negDiagonal)) {
                continue;
            }

            // add the queen to the board
            colSet.add(col);
            posSet.add(posDiagonal);
            negSet.add(negDiagonal);
            state[row][col] = 'Q';

            // move to the next row with our update board state
            backtrack(row + 1, colSet, posSet, negSet, state, n);

            // UNDO all of what we just did for the next iteration of what we just did
            colSet.remove(col);
            posSet.remove(posDiagonal);
            negSet.remove(negDiagonal);
            state[row][col] = '.';
        }
    }
}
