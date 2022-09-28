class Solution {
    
    private enum NodeState{
        UNVISITED,
        VISITING,
        VISITED
    };
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        //We need to represent this into graph to detect cycles
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] requirement : prerequisites)
            graph.get(requirement[0]).add(requirement[1]);
        NodeState[]state = new NodeState[numCourses];
        for(int i =0; i<numCourses; i++){
            state[i] = NodeState.UNVISITED;
        }
        for(int i =0; i<numCourses; i++){
            if(state[i]==NodeState.UNVISITED){
               if(dfs(i,state,graph)){
                   return false;
               }
            }
        }
        return true;


    }
    public static boolean dfs(int node , NodeState[]state,  List<List<Integer>> graph){
        state[node]= NodeState.VISITING;
        boolean hasCycle = false;
        for(int v : graph.get(node)){
            if(state[v]==NodeState.UNVISITED){
                hasCycle|=dfs(v,state,graph);

            }else if(state[v]==NodeState.VISITING){
                hasCycle =true;


            }
        }
        state[node]=NodeState.VISITED;

        return hasCycle;
    }
}