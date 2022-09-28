class Solution {
  public int numIslands(char[][] grid) {
     

      final int N = grid.length, M = grid[0].length;
      boolean visited[][] = new boolean[N][M];
      
      int islandNum = 0;
      for (int i = 0; i < N; i++)
          for (int j = 0; j < M; j++)
              if (grid[i][j] == '1' && !visited[i][j]) {
                  islandNum++;
                  dfs(i, j, grid, visited);
              }

      return islandNum;
  }
  private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
          return;
      if (grid[i][j] != '1' || visited[i][j])
          return;

      visited[i][j] = true;
      
      dfs(i - 1, j, grid, visited);
      dfs(i + 1, j, grid, visited);
      dfs(i, j - 1, grid, visited);
      dfs(i, j + 1, grid, visited);
  }
}