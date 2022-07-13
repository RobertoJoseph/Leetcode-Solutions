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

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distances, -1);
        distances[node] = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int child : adjList[x]) {
                if (distances[child] == -1) {
                    distances[child] = distances[x] + 1;
                    queue.add(child);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            adjList = new ArrayList[n];
            distances = new int[n];
            for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
            while (m-- > 0) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                adjList[u].add(v);
                adjList[v].add(u);
            }
            bfs(0);
            ArrayList<Integer> evens = new ArrayList<>();
            ArrayList<Integer> odds = new ArrayList<>();
            for (int i = 0; i < distances.length; i++) {
                if ((distances[i] % 2 == 0)) evens.add(i + 1);
                else odds.add(i + 1);
            }
            if (evens.size() <= odds.size()) {
                pw.println(evens.size());
                for (int i = 0; i < evens.size(); i++) {
                   pw.print(evens.get(i) + " ");
                }

            } else if (odds.size() < evens.size()) {
                pw.println(odds.size());
                for (int i = 0; i < odds.size(); i++) {
                   pw.print(odds.get(i) + " ");
                }
            }




        }
        pw.flush();
        pw.close();


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
