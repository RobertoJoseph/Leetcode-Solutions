class Solution {
    boolean visited[][];
  public int numIslands(char[][] grid) {
     

      final int N = grid.length, M = grid[0].length;
      visited = new boolean[N][M];
      
      int islandNum = 0;
      for (int i = 0; i < N; i++)
          for (int j = 0; j < M; j++)
              if (grid[i][j] == '1' && !visited[i][j]) {
                  islandNum++;
                  dfs(i, j, grid);
              }

      return islandNum;
  }
  private void dfs(int i, int j, char[][] grid) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
          return;
      if (grid[i][j] != '1' || visited[i][j])
          return;

      visited[i][j] = true;
      
      dfs(i - 1, j, grid);
      dfs(i + 1, j, grid);
      dfs(i, j - 1, grid);
      dfs(i, j + 1, grid);
  }
}