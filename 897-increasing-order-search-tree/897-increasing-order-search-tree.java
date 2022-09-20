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
    TreeNode ans;
    List<Integer> result = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode ans = new TreeNode(0);
          TreeNode cur=ans;
        for (int x : result) {
            cur.right = new TreeNode(x);
            cur = cur.right;
            
        }
        System.out.println(result);
        return ans.right;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            result.add(root.val);
            inorder(root.right);
        }
    }
}
