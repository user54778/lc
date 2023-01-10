package backtracking;

public class WordSearch {
    private boolean[][] visited;
    private final int[] rDir = new int[] {0, 1, 0, -1}; // right and left
    private final int[] cDir = new int[] {1, 0, -1, 0}; // up and down
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        visited = new boolean[r][c];

        // go through every position in our grid
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // run our backtracking algorithm
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;   // word doesn't exist
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // index same length as word, must be the word
        if (index >= word.length()) {
            return true;
        }

        // boundary check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)
                || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;   // visited cell in grid
        /*
         * Run through each direction in the grid.
         */
        for (int i = 0; i < 4; i++) {
            // increment current character in target word index
            if (backtrack(board, word, r + rDir[i], c + cDir[i], index + 1)) {
                return true;
            }
        }
        visited[r][c] = false;  // stop visiting current position; backtracking part
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(wordSearch.exist(board, "ABCB"));
    }
}
