class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // if the neighboring cell's height is less than or equal to the current cell's height.
        // Water can flow from any cell adjacent to an ocean into the ocean.
        List<List<Integer>> res = new ArrayList<>();
        int ROW = heights.length;
        int COL = heights[0].length;
        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] alt = new boolean[ROW][COL];
        // ROW
        for (int i = 0; i < ROW; i++) {
            // from pac to atl, upper left to down
            pacificAtlanticDfs(i, 0, pac, heights, heights[i][0]);
            // from atl to pac, bottom right to up
            pacificAtlanticDfs(i, COL - 1, alt, heights, heights[i][COL - 1]);
        }
        for (int j = 0; j < COL; j++) {
            // from pac to atl, upper left to right
            pacificAtlanticDfs(0, j, pac, heights, heights[0][j]);
            // from atl to pac, bottom right to left
            pacificAtlanticDfs(ROW - 1, j, alt, heights, heights[ROW - 1][j]);
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (pac[i][j] && alt[i][j]) res.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return res;
    }

    public void pacificAtlanticDfs(int i, int j, boolean[][] isVisited, int[][] heights, int prevHeight) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < prevHeight || isVisited[i][j]) return;
        isVisited[i][j] = true;
        pacificAtlanticDfs(i + 1, j, isVisited, heights, heights[i][j]);
        pacificAtlanticDfs(i - 1, j, isVisited, heights, heights[i][j]);
        pacificAtlanticDfs(i, j + 1, isVisited, heights, heights[i][j]);
        pacificAtlanticDfs(i, j - 1, isVisited, heights, heights[i][j]);
    }
}