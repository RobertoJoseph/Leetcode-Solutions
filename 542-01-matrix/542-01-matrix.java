class Solution {
   
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll(); //MyOriginalNode
            for (int[] dir : directions) {
                int newXDirection = node[0] + dir[0];
                int newYDirection = node[1] + dir[1];
                if (isSafe(newXDirection, newYDirection, mat)) {
                    if (distances[newXDirection][newYDirection] > distances[node[0]][node[1]] + 1) {
                        distances[newXDirection][newYDirection] = distances[node[0]][node[1]] + 1;
                        queue.add(new int[]{
                            newXDirection, newYDirection
                        });
                    }
                }

            }

        }
        return distances;
    }


    public boolean isSafe(int i, int j, int[][] mat) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[i].length) return false;
        return true;
    }

}