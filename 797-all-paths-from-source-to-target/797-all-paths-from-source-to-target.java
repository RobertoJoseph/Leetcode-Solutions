class Solution {
   
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        dfs(graph, path, 0);
        return result;
    }

    public void dfs(int[][] graph, List<Integer> path, int u) {
        path.add(u);
        if (u == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else
            for (int node : graph[u]) {
                dfs(graph, path, node);
            }
        path.remove(path.size() - 1);
    }
}