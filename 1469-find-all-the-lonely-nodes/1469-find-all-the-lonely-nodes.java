/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
       if(root!=null){
           recursive(root.left,root);
           recursive(root.right,root);
           
       }
        return result;
        
    }

    private void recursive(TreeNode node, TreeNode parent) {
        if(node==null)return;
        if(parent.left==null||parent.right==null)
            result.add(node.val);
        recursive(node.left,node);
        recursive(node.right,node);
        
    }
}
