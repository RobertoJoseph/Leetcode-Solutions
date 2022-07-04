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
    static List<Integer> adjlist[] = new ArrayList[N];
    static boolean[] visited = new boolean[N];
    static int color[] = new int[N];
    static boolean flag = false;
    static int ans = Integer.MIN_VALUE;
    static int cnt = 0;
    static boolean[] inPath;
    static boolean isCyclic = false;

    public static void bfs(int node) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(node);
        color[node] = 1;
        while (!qu.isEmpty()) {
            int u = qu.peek();
            qu.poll();
            for (int x : adjlist[u]) {
                if (color[x] != 0) {
                    if (color[x] == color[u]) {
                        flag = true;
                        break;
                    }

                } else {
                    color[x] = 3 - color[u];
                    qu.add(x);
                }

            }

        }

    }


    public static void dfs(int i) {
        visited[i] = true;
        inPath[i] = true;
        for (int node : adjlist[i]) {
            if (!visited[node]) {
                dfs(node);
            } else if (inPath[node]) {
                isCyclic = true;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        adjlist = new ArrayList[n];
        for (int i = 0; i < n; i++) adjlist[i] = new ArrayList<>();
        visited = new boolean[n];
        inPath = new boolean[n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            adjlist[x].add(y);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        if (isCyclic) {
            System.out.println("NO");
        } else {
            if (m == (n - 1) && !isCyclic) System.out.println("YES");
            else System.out.println("NO");

        }


    }

    /**
     * Fixed Window Find the max sum subarray of a fixed size K
     * <p>
     * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
     */
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

    // Dynamic Window
    public static int smallestSubarray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];
            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }

    // better solution for less steps
    // public static int dfs(int node) {
    // visited[node] = true;
    // int c = 1;
    // for (int i : adjList[node]) {
    // if (!visited[i]) {
    // c += dfs(i);
    // }
    // }
    // return c;
    // Getting last occur of element
    // public static int binarySearch(int low, int n, int high) {
    // low = 0;
    // high = n - 1;
    // while (low <= high) {
    // int mid = (low + high) / 2;
    // if (x >= a[mid]) {
    // if (x == a[mid]) {
    // ans = mid;
    // }
    // low = mid + 1;
    //
    // } else if (a[mid] > x) {
    // high = mid - 1;
    // }
    // }
    //
    // }
    public static int gcdFast(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcdFast(y, x % y);
        }
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
