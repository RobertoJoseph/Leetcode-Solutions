class Solution {
    List<Integer>result = new LinkedList<>();
    HashSet<Integer>visited = new HashSet<>();
    HashSet<Integer>cycle = new HashSet<>();
      List<List<Integer>>graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
      graph = new ArrayList<>();
        for(int i =0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[]req: prerequisites){
            graph.get(req[0]).add(req[1]);
        }
        int[]order = new int[0];
        for(int i =0; i<numCourses; i++){
            if(dfs(i)==false) return order;
        }
        int[]res = new int[result.size()];
        for(int i =0; i<result.size(); i++){
            res[i]=result.get(i);
        }
        return res;
        
        
        
           
    }
    public boolean dfs(int i ){
        if(cycle.contains(i))return false;
        if(visited.contains(i))return true;
        cycle.add(i);
        for(int v : graph.get(i)){
            if(!dfs(v))return false;
        }
        cycle.remove(i);
        visited.add(i);
        result.add(i);
        return true;
        
    }
}