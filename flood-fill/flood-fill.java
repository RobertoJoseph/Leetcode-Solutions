class Solution {
    
    boolean [][]visited;
    int pixelColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        pixelColor = image[sr][sc];
        dfs(sr,sc,color,image);
        return image;
        
    }
    
    public void dfs(int i,int j, int color,int[][]image){
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length)
            return;
        if(visited[i][j])return;
        if(image[i][j]!=pixelColor)return;
        if(image[i][j]==pixelColor){
            image[i][j]=color;
        }
        visited[i][j]=true;
        dfs(i+1,j,color,image);
        dfs(i,j+1,color,image);
        dfs(i-1,j,color,image);
        dfs(i,j-1,color,image);
        
    }
    
    
}