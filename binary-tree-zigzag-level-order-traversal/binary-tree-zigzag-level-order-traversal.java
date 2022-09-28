class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;
        
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
                if(even)
                    subList.add(top.val);
                else
                    subList.addFirst(top.val);
            }
            list.add(subList);
            even = !even;
        }
        
        return list;
    }
}