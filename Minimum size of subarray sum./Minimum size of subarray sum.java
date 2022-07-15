import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class problemE {

    static int r = (int) 1e9;
    static ArrayList<Integer> adjList[];
    static int V;
    static int white = 0;
    static boolean[] visited;
    static long mod = (long) 1e9 + 7;
    static int[] distances;
    static int[] nxt;
    static int[] end;
    static int[] size;




    public static int minimumSizeSubarraySum(int[] arr, int k) {
        int startIndex = 0;
        long maxSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
            maxSum += arr[endIndex];
            while (maxSum >= k) {
                minLength = Math.min(minLength, endIndex - startIndex + 1);
                maxSum -= arr[startIndex];
                startIndex++;
            }
        }
        if (minLength == Integer.MAX_VALUE) return -1;
        else return minLength;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int[] arr = {2, 3, 1, 2, 1, 3};
        int k = 7;
        System.out.println(minimumSizeSubarraySum(arr, 7));


    }




    class Pair implements Comparable<Pair> {
        double x, y;

        public Pair(double x, int y) {
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


    public static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public int[] nextArr(int n) throws IOException {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
    }

}
