class Solution {
    class Pair implements Comparable<Pair>{
        double x;
        int y;
        public Pair(double x , int y){
            this.x = x;
            this.y = y;
            
        } 
        public int compareTo(Pair p) {
            if (x < p.x) {
                return -1;
            } else if (x > p.x) return 1;
            return 0;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Pair[] pairs = new Pair[points.length];
        int size = points.length;
        for (int i = 0; i < size; i++) {
            int x = (int) Math.pow(points[i][0], 2);
            int y = (int) Math.pow(points[i][1], 2);
            double result = Math.sqrt(x + y);
            pairs[i] = new Pair(result, i);
        }
        Arrays.sort(pairs);
        int[][] result = new int[k][2];
        for (int i = 0; i < pairs.length; i++) {
            if (k != 0) {
                int pos = pairs[i].y;
                int[] ans = points[pos];
                result[i][0] = ans[0];
                result[i][1] = ans[1];
                k--;
            }
        }
        return result;
    }
}