class Solution {
	int rows;
	int cols;

	public boolean isValid(int row, int col) {
		return row >= 0 && col >= 0 && row < rows && col < cols;
	}

	int[][] moves = new int[][] { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

	public int maxDistance(int[][] grid) {
		int n = grid.length,m=grid[0].length;
		rows = n;cols = m;
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==1){
					queue.add(new int[]{i,j});
				}
			}
		}
		return bfs(grid,queue);
	}

	int bfs(int[][] grid,Queue<int[]> queue){
		int ans = 0;
		while(!queue.isEmpty()){
			int n = queue.size();
			boolean isFound = false;
			while(n>0){
				int[] water = queue.poll();
				for(int[] move:moves){
					int row = move[0]+water[0];
					int col = move[1]+water[1];
					if(!isValid(row,col)) continue;
					if(grid[row][col]==1) continue;
					queue.add(new int[]{row,col});
					grid[row][col]=1;
					isFound=true;
				}
				n--;
			}
			if(isFound) ans++;
		}
		return ans==0?-1:ans;
	}
}