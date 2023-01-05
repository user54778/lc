package graphs;

public class MaxAreaOfIsland {
    private boolean[][] visited;    // boolean 2d array to mark as visited

    /**
     * Find the max area of an Island in a matrix filled with 1's and 0's.
     * 1's are islands.
     * 0's are water.
     * @param grid matrix
     * @return max area of an island
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;        // max area
        int r = grid.length;    // rows
        int c = grid[0].length; // columns
        visited = new boolean[r][c];    // visited boolean array

        // traverse the matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {    // if cell isn't visited, and we are on a 1, perform DFS
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea; // max area of island
    }

    /**
     * Perform dfs; will ONLY perform if we are ALREADY on an island, aka we ran into a 1.
     * This dfs also calculates the area of the island we are on.
     * @param grid grid to perform dfs on
     * @param r rows
     * @param c columns
     * @return area of the island we are on
     */
    private int dfs(int[][] grid, int r, int c) {
        // basic checking
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;   // ensure we dont recount cells
        if (grid[r][c] == 0) {
            return 0;
        }
        int count = 1;  // cell we are on is a 1, so count starts at 1
        /*
         * Perform dfs in all four directions; add all areas of its neighbors
         */
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r, c - 1);
        return count;
    }
}
