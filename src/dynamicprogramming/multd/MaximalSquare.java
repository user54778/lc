package dynamicprogramming.multd;

import java.util.HashMap;
import java.util.Map;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        Map<String, Integer> cache = new HashMap<>();
        dp(0, 0, cache, matrix);
        int maxLength = 0;
        for (Integer value : cache.values()) {
            maxLength = Math.max(maxLength, value);
        }

        return maxLength * maxLength;
    }

    // we cache the max LENGTH of the square
    private int dp(int row, int col, Map<String, Integer> cache, char[][] matrix) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 0;   // out of bounds check
        }

        String key = row + "," + col;   // string representation of the row,col
        if (!cache.containsKey(key)) {
            // need to check down, right, diagonal
            int down = dp(row + 1, col, cache, matrix);
            int right = dp(row, col + 1, cache, matrix);
            int diag = dp(row + 1, col + 1, cache, matrix);

            cache.put(key, 0);  // initially zero length in position
            if (matrix[row][col] == '1') {
                cache.put(key, 1 + Math.min(Math.min(down, right), diag));
            }
        }
        return cache.get(key);
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] { {'1','0','1','0','0'},
            {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'} };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
