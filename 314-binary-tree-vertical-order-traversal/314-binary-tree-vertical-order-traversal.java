/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<List<Integer>> verticalOrder(TreeNode root) {
        
     List<List<Integer>>list = new ArrayList<>();
      if(root==null)return list;
      Map<Integer,ArrayList>columnTable = new HashMap();
      Queue<Pair<TreeNode,Integer>>queue = new LinkedList<>();
      queue.add(new Pair(root,0));
      int column;
      while(!queue.isEmpty()){
         Pair<TreeNode, Integer> p = queue.poll();
          root = p.getKey();
          column = p.getValue();
          if(!columnTable.containsKey(column)){
              columnTable.put(column,new ArrayList<Integer>());
          }
          columnTable.get(column).add(root.val);
          if(root.left!=null)queue.add(new Pair(root.left,column-1));
          if(root.right!=null)queue.add(new Pair(root.right,column+1));
         
          
      }
      List<Integer>sortedKeys = new ArrayList<Integer>(columnTable.keySet());
      Collections.sort(sortedKeys);
      for(int k : sortedKeys){
          list.add(columnTable.get(k));
      }
      return list;
 
  }
}