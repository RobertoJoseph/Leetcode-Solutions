import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class problemE {
    static int N = (int) (5e3 + 2);
    static int n;
    static int m;
    static List<Character> adjlist[] = new ArrayList[N];
    static boolean[][] visited;
    static int color[] = new int[N];
    static boolean flag = false;
    static int ans = Integer.MIN_VALUE;
    static int cnt = 0;
    static boolean[] inPath;
    static boolean isCyclic = false;
    static long sum = 0;
    static long max = -1;
    static long sumBranchesOnly = 0;
    static long savedAns = 0;
    static Edge g;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};


    public static boolean dfs(int i, int j, char[][] arr) {
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        boolean flag = false;
        visited[i][j] = true;
        for (int start = 0; start < 2; start++) {
            int newRow = i + dr[start];
            int newCol = j + dc[start];
            if (isSafe(newRow, newCol, arr) && !visited[newRow][newCol] && arr[newRow][newCol] == '.') {
                flag = flag || dfs(newRow, newCol, arr);
            }
        }
        return flag;

    }

    public static boolean isSafe(int i, int j, char[][] arr) {
        return i < n && j < m;
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n][m];
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] a = s.toCharArray();
            for (int j = 0; j < a.length; j++) {
                arr[i][j] = a[j];
            }
        }
        //If he could not reach arr[n][m] print zero
        if (!dfs(0, 0, arr))
            System.out.println(0);
            //It means he passes the first condition and reached arr[n][m]
            // I will DFS again to see if he can reach it again
        else if (dfs(0, 0, arr))
            System.out.println(2);
            //It means that only one way is available for him to arr[n][m]
        else
            System.out.println(1);


    }

    /**
     * Fixed Window Find the max sum subarray of a fixed size K
     * <p>
     * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
     */

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public static int findMaxSumSubarray(int[] arr, int k) {
            int maxValue = Integer.MIN_VALUE;
            int currentRunningSum = 0;
            for (int i = 0; i < arr.length; i++) {
                currentRunningSum += arr[i];
                if (i >= k - 1) {
                    maxValue = Math.max(maxValue, currentRunningSum);
                    currentRunningSum -= arr[i - (k - 1)]; // Akher element fl 3 bto3 el K
                }
            }
            return maxValue;
        }


        public static class Pair implements Comparable<Pair> {
            int a, b;

            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public int compareTo(Pair A) {
                return this.a > A.a ? 1 : -1; // sorting ascending
            }
        }

        public static int findLength(String str, int k) {
            int windowStart = 0, maxLength = -1;
            HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
            for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
                char rightChar = str.charAt(windowEnd);
                hs.put(rightChar, hs.getOrDefault(rightChar, 0) + 1); // Increasing its value by 1 and if it have no value
                // just its zero and add 1
                while (hs.size() > k) {
                    char leftChar = str.charAt(windowStart);
                    hs.put(leftChar, hs.get(leftChar) - 1);
                    if (hs.get(leftChar) == 0) {
                        hs.remove(leftChar);
                    }
                    windowStart++;
                }
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }
            return maxLength;
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

}
