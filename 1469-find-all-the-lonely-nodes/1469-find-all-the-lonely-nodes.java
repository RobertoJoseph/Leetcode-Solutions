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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root != null) {
            recursive(result, root.left, root);
            recursive(result, root.right, root);
        }
        
        return result;
    }
    
    private void recursive(List<Integer> nodes, TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        
        if (parent.left == null || parent.right == null)
            nodes.add(node.val);
        
        recursive(nodes, node.left, node);
        recursive(nodes, node.right, node);
    }
}