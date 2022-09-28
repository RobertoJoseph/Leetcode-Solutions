class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            LinkedList<Integer> subList = new LinkedList<>();
            
            for(int i = 0; i < n; i++){
                TreeNode top = q.poll();
                
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
               
                    subList.add(top.val);
              
                    
            }
            list.add(subList);
           
        }
        
        return list;
    }
}