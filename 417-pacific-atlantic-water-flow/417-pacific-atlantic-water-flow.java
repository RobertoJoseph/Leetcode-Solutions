class Solution {
     int[][] count;
    List<List<Integer>> list; 
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
     list = new ArrayList<>();
      int r = heights.length;
        int c = heights[0].length;
       count = new int[r][c];
        pacific(heights, count);
        atlantic(heights, count);
       for(int i = 0;i<r;i++){
         for(int j = 0;j<c;j++){
           if(count[i][j]==2){
              List<Integer> arr = new ArrayList<>();
             arr.add(i);
             arr.add(j);
             list.add(new ArrayList<>(arr));
           }
         }
       }
        return list;
    }
  
    public void dfs(int[][] grid, boolean[][] visited, int r, int c, int p,  int[][] count){
        if(r>=grid.length||r<0|c>=grid[0].length||c<0)return;
        if(visited[r][c]==true || grid[r][c]<p)return;
        
        visited[r][c] = true;
        count[r][c] += 1;
        p = grid[r][c];
        dfs(grid, visited, r-1, c, p, count);
       dfs(grid, visited, r+1, c, p, count);
       dfs(grid, visited, r, c-1, p, count);
       dfs(grid, visited, r, c+1, p, count);

        
    }
    public void pacific(int[][] heights, int[][] count){
        int r = heights.length;
        int c = heights[0].length;
       boolean[][] visited = new boolean[r][c];
       for(int i=0;i<c;i++){
            if(visited[0][i]==false){
                dfs(heights,visited,0,i,-1, count);
            }
        }
        for(int i=0;i<r;i++){
            if(visited[i][0]==false ){
                dfs(heights,visited,i,0,-1, count);
            }
        }
    }
  
   public void atlantic(int[][] heights, int[][] count){
        int r = heights.length;
        int c = heights[0].length;
       boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            if(visited[i][c-1]==false){
                dfs(heights,visited,i,c-1, -1, count);
            }
        }
        for(int i=0;i<c;i++){
            if(visited[r-1][i]==false){
                dfs(heights,visited,r-1,i, -1, count);
            }
        }
    }
}