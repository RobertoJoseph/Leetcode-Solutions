/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val,Node next,Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
*/

class Solution {
    
    HashMap<Node,Node>visited = new HashMap<>();
    
    public Node getClonedNode(Node node){
        if(node==null)return null;
        if(visited.containsKey(node)){
            return visited.get(node);
        }else{
            visited.put(node,new Node(node.val,null,null));
            return visited.get(node);
        }
        
    }
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode,newNode);
        while(oldNode!=null){
            newNode.next = getClonedNode(oldNode.next);
            newNode.random = getClonedNode(oldNode.random);
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        
        return visited.get(head);
       
    }
    
    
}