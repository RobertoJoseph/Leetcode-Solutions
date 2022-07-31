/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val,Node next , Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
*/

class Solution {
    
  HashMap<Node, Node> visited = new HashMap<Node, Node>();
    
    
    
    
    
    public Node getOrAddNode(Node n){
        if(n==null)return null;
        
        if(visited.containsKey(n)){
            return visited.get(n);
        }else{
            visited.put(n,new Node(n.val));
            return visited.get(n);
        }
        
        
        
    }
    
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        
        Node oldNode = head;
        
        
        Node newNode = new Node(head.val);
    
        
        visited.put(oldNode,newNode);
        
        while(oldNode!=null){
            
            newNode.next = this.getOrAddNode(oldNode.next);
            newNode.random = this.getOrAddNode(oldNode.random);
            
            newNode = newNode.next;
            oldNode = oldNode.next;
            
            
        }
        return visited.get(head);
        
       
    }
}