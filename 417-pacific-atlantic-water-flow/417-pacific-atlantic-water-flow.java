class Solution {
   
    private static List<List<Integer>> ans;

    public static boolean findValueInPair(Pair x, HashSet<Pair> hs) {
        for (Pair temp : hs) {
            if (temp.x == x.x && temp.y == x.y) return true;
        }
        return false;
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        ans = new ArrayList<>();
        HashSet<Pair> pac = new HashSet<>();
        HashSet<Pair> atl = new HashSet<>();
        int rows = heights.length;
        int cols = heights[0].length;
        for (int c = 0; c < heights[0].length; c++) {
            dfs(0, c, heights, heights[0][c], pac);
            dfs(rows - 1, c, heights, heights[rows - 1][c], atl);
        }
        for (int r = 0; r < heights.length; r++) {
            dfs(r, 0, heights, heights[r][0], pac);
            dfs(r, cols - 1, heights, heights[r][cols - 1], atl);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                Pair x = new Pair(i, j);
                if (findValueInPair(x, atl) && findValueInPair(x, pac))
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return ans;
    }

    public static void dfs(int i, int j, int[][] heights, int prevHeight, HashSet<Pair> visited) {
        if (i < 0 || j < 0 || i >= heights.length
            || j >= heights[0].length || findValueInPair(new Pair(i, j), visited) ||
            heights[i][j] < prevHeight) return;
        visited.add(new Pair(i, j));
        dfs(i + 1, j, heights, heights[i][j], visited);
        dfs(i - 1, j, heights, heights[i][j], visited);
        dfs(i, j + 1, heights, heights[i][j], visited);
        dfs(i, j - 1, heights, heights[i][j], visited);
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }


        public int compareTo(Pair A) {
            return this.y > A.y ? -1 : 1; // sorting ascending
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + '}';
        }

    }

}