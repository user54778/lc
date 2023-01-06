package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSodoku {
    public static boolean isValidSudoku(char[][] board) {

        // first case
        for (int row = 0; row < board.length; row++) {
            Set<Character> rowSet = new HashSet<>();    // create a new hashset each row
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (rowSet.contains(board[row][col])) {
                    return false;
                }
                rowSet.add(board[row][col]);
            }
        }

        // second case
        for (int row = 0; row < board.length; row++) {
            Set<Character> colSet = new HashSet<>();    // same idea as for rows
            for (int col = 0; col < board[0].length; col++) {
                if (board[col][row] == '.') {
                    continue;
                }

                if (colSet.contains(board[col][row])) {
                    return false;
                }
                colSet.add(board[col][row]);
            }
        }

        // third case
        for (int i = 0; i < board.length; i = i + 3) {  // sub block is every 3 blocks in board
            for (int j = 0; j < board[0].length; j = j + 3) {   // iterate per 3 blocks
                if (!checkValidSubBlock(i, j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Helper method for determining our third condition where each sub-box must contain
     * digits 1-9 AND can't be repeated.
     * @param r row
     * @param c column
     * @param board board
     * @return true iff pass two conditions
     */
    private static boolean checkValidSubBlock(int r, int c, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int subRowTraverse = r + 3; // traverse per 3
        int subColTraverse = c + 3;

        // subRow and subCol will be 3 blocks ahead to allow our 3 x 3 block iteration
        for (int row = r; row < subRowTraverse; row++) {
            for (int col = c; col < subColTraverse; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (blockSet.contains(board[row][col])) {
                    return false;
                }

                blockSet.add(board[row][col]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
