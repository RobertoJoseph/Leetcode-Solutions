public class problemE {
    static int r = (int) 1e9;
    static ArrayList<Integer> adjList[];
    static int n;
    static int m;
    static boolean[] visited;
    static int distances[];

    public static int BFS(int i, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        Arrays.fill(distances, -1);
        distances[i] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == dest) {
                return distances[dest] / 3;
            }
            for (int child : adjList[u]) {
                if (distances[child] == -1) {
                    distances[child] = distances[u] + 1;
                    queue.add(child);
                }
            }
        }
        return -1;


    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adjList = new ArrayList[3 * n];
        distances = new int[3 * n];
        for (int i = 0; i < 3 * n; i++) adjList[i] = new ArrayList<>();
        while (m-- > 0) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adjList[3 * u].add(3 * v + 1);
            adjList[3 * u + 1].add(3 * v + 2);
            adjList[3 * u + 2].add(3 * v);
        }
        int s = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        System.out.println(BFS(3*s,3*v));

    }

