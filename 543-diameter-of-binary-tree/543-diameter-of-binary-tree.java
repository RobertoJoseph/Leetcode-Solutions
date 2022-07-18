class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
       diameter = 0;
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNode node){
        if(node==null)return 0;
        
        int leftHeight = longestPath(node.left);
        int rightHeight = longestPath(node.right);
        
        diameter = Math.max(diameter,leftHeight+rightHeight);
        
        return 1+Math.max(leftHeight,rightHeight);
  
}
}