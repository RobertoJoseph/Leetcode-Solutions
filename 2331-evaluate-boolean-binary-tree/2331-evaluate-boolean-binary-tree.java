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
    int finalVal;
    public boolean evaluateTree(TreeNode root) {
            //PostOrder left,right,node
        return eval(root);
    }
    
    public boolean eval(TreeNode root){
        
       if(root.val==1)return true;
        if(root.val==0)return false;
        if(root.val==2){
            return eval(root.left)|eval(root.right);
        }
        return eval(root.right)&&eval(root.left);
        
        
        
        
        
    }
}