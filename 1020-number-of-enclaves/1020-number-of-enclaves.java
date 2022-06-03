class Solution {
   
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1) {
                        dfs(i, j, grid);
                    }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        return count;

    }

    //J is column length =end
    //I is the row length = start
    public void dfs(int start, int end, int[][] grid) {
        if (start < 0 || end < 0 || start >= grid.length || end >= grid[0].length || grid[start][end] == 0) return;
        grid[start][end] = 0;
        dfs(start + 1, end, grid);
        dfs(start - 1, end, grid);
        dfs(start, end - 1, grid);
        dfs(start, end + 1, grid);


    }
}