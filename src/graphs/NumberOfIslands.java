package graphs;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        // edge cases
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        // otherwise, perform dfs on all four sides of our current element in the grid
        grid[i][j] = 'v';   // mark as visited
        dfs(grid, i + 1, j);    // up
        dfs(grid, i, j + 1);    // right
        dfs(grid, i - 1, j);    // down
        dfs(grid, i, j - 1);    // left
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]
        {   {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}}));
    }
}
