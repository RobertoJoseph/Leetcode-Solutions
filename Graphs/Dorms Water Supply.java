import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class problemE {

    static int r = (int) 1e9;
    static ArrayList<Pair> adjList[];
    static int n;
    static int m;
    static boolean[] visited;
    static ArrayList<AdvPair> result = new ArrayList<>();

//
//    public static int BFS(Pair x, Pair y) {
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(x);
//        distanceV.put(x, 0);
//        while (!queue.isEmpty()) {
//            Pair cur = queue.poll();
//            int row = cur.a;
//            int col = cur.b;
//            if (row == y.a && col == y.b) {
//                return distanceV.get(cur);
//            }
//            for (int i = 0; i < 8; i++) {
//                int newRow = row + dx[i];
//                int newCol = col + dy[i];
//                Pair nxt = new Pair(newRow, newCol);
//                if (isValid(newRow, newCol, nxt)) {
//                    queue.add(nxt);
//                    distanceV.put(nxt, distanceV.get(cur) + 1);
//                }
//            }
//
//        }
//        return -1;
//    }

    public static class AdvPair {
        int a;
        int b;
        int weight;

        public AdvPair(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

    }

    public static void dfs(int node, int minD, int parent) {
        visited[node] = true;
        if (adjList[node].isEmpty()) {
            if (minD != (1e9)) {
                result.add(new AdvPair(parent + 1, node + 1, minD));
            }
        }
        for (Pair child : adjList[node]) {
            if (!visited[child.destination]) {
                dfs(child.destination, Math.min(minD, child.weight), parent);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] inDeg = new int[n];
        int[] outDeg = new int[n];
        adjList = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            outDeg[u]++;
            inDeg[v]++;
            adjList[u].add(new Pair(v, w));
        }
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0 && outDeg[i] != 0 && !visited[i]) {
                //It is the tank, so DFS from it
                dfs(i, (int) 1e9, i);
            }
        }
        System.out.println(result.size());
        for (AdvPair ap : result) {
            System.out.println(ap.a + " " + ap.b + " " + ap.weight);
        }


    }

    /**
     * Fixed Window Find the max sum subarray of a fixed size K
     * <p>
     * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
     */


    public static class Pair {
        int destination, weight;

        public Pair(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
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
