class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int step = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                int[] ver = queue.poll();
                if(ver[0] == grid.length-1 && ver[1] == grid[0].length-1)
                    return step;
                 for(int[] dir : directions) {
                    int newX = ver[0]+dir[0];
                    int newY = ver[1]+dir[1];
                    if(isSafe(grid,newX, newY, visited)) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX,newY});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public boolean isSafe(int[][] grid, int x, int y, boolean[][] visited) {
        if(x<0 || y<0 || x>=grid.length || y>=grid[x].length || visited[x][y] || grid[x][y] == 1)
            return false;
        return true;
    }  
}