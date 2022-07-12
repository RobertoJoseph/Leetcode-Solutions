import java.util.*;

public class MST_Kruskal {
	static ArrayList<Edge> edgeList;
	static int V;
	static int start = 0;
	static ArrayList<Character> chars;
	static int cnt = 0;
	static boolean flag = false;

	static long kruskal() // O(E log E)
	{
		long mst = 0;
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(V);
		for (Edge e : edgeList)
			if (uf.findParent(e.u) != uf.findParent(e.v)) {
				mst += e.w;
				uf.joinSet(e.u, e.v);
			}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		Edge(int a, int b, int c) {
			u = a;
			v = b;
			w = c;
		}

		public int compareTo(Edge e) {
			return w - e.w;
		}
	}

	static class UnionFind {
		int[] p, sizeParent;

		public UnionFind(int N) {
			p = new int[N];
			sizeParent = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				sizeParent[i] = 1;
			}
		}

		public int findParent(int i) {
			if (p[i] == i)
				return i;
			else
				return p[i] = findParent(p[i]);
		}

		public Boolean isSameSet(int i, int j) {
			return findParent(i) == findParent(j);
		}

		public void joinSet(int i, int j) {
			if (isSameSet(i, j)) {
				flag = true;
				return;
			}
			int x = findParent(i), y = findParent(j);
		
			p[x]=p[y]=Math.max(x,y);
			sizeParent[x] += sizeParent[y];

		}

	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair A) {
			return this.a > A.a ? 1 : -1; // sorting ascending
		}

		public String toString() {
			return a + " " + b;
		}

		public boolean isEqual(Pair y) {
			return a == y.a && b == y.b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		UnionFind u1 = new UnionFind(n);
		while (m-- > 0) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			
			u1.joinSet(u, v);
		}
		int ans = 0;
		for (int i = 0; i < n;) {
			int max = u1.findParent(i);
			for (int j = i + 1; j < max; j++) {
				if(u1.findParent(i)!=u1.findParent(j)) {
					ans++;
					u1.joinSet(i, j);
				}

			}
      //Single component parent of itself
			i = Math.max(i+1, max);
		}System.out.println(ans);

	}

//		

}
