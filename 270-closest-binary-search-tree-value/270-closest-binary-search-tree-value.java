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
    double min = Double.MAX_VALUE;
    int node;
    public int closestValue(TreeNode root, double target) {
        bfs(root,target);
        return node;
    }
    
    public void bfs(TreeNode root,double target){
         Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(Math.abs(cur.val-target)<min){
                min = Math.abs(cur.val-target);
                node = cur.val;
            }
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null)queue.add(cur.right);
        }
    }
    
    
    
}