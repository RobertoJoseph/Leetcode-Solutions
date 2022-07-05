import java.util.*;

public class C242 {
    static TreeSet<Pair> allowed;
    static TreeMap<Pair, Integer> visited;
    static int r = (int) 10e9;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }

        public int compareTo(Pair p) {
            if (x - p.x == 0)
                return y - p.y;
            return x - p.x;
        }


    }

    public static boolean isValid(int x, int y, Pair nxt) {
        return x > 0 && y > 0 && x < r && y < r && allowed.contains(nxt) && !visited.containsKey(nxt);
    }

    public static int bfs(Pair s, Pair d) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(s);
        visited.put(s, 0);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if (x == d.x && y == d.y)
                return visited.get(cur);
            for (int i = 0; i < 8; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                Pair nxt = new Pair(xx, yy);
                if (isValid(xx, yy, nxt)) {
                    q.add(nxt);
                    visited.put(nxt, visited.get(cur) + 1);
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair s = new Pair(sc.nextInt(), sc.nextInt());
        Pair d = new Pair(sc.nextInt(), sc.nextInt());
        allowed = new TreeSet<>();
        visited = new TreeMap<>();
        int n = sc.nextInt();
        while (n-- > 0) {
            int r = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int i = a; i <= b; i++) {
                allowed.add(new Pair(r, i));
            }
        }
        System.out.println(bfs(s, d));

    }

}
