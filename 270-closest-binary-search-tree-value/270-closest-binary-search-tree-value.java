class Solution {
  public int closestValue(TreeNode root, double target) {
      int curNode =-1;
        double min = Double.MAX_VALUE;
      while(root!=null){
          if(Math.abs(root.val-target)<min){
              min = Math.abs(root.val-target);
              curNode = root.val;
          }
          root = target<root.val?root.left:root.right;
      }
      return curNode;
      
  }
}