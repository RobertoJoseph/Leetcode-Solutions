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
        List<Integer>result = new LinkedList();
        Queue<TreeNode>queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null&&temp.right!=null){
                queue.add(temp.left);
                queue.add(temp.right);
            }else if(temp.left!=null&&temp.right==null){
                result.add(temp.left.val);
                queue.add(temp.left);
            }
            else if(temp.right!=null&&temp.left==null){
                result.add(temp.right.val);
                queue.add(temp.right);
            }
            
        }return result;
    }
}