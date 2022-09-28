/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        //Getting the size of the list
        int size=0;
        while(cur!=null){
            size+=1;
            cur=cur.next;
        }
        cur = head;
        System.out.println(size);
        int tries = size/k;
        ListNode prev = null;
        ListNode test = new ListNode(-1);
        ListNode ans = test;
            int count = k;
        while(cur!=null&&tries!=0){
            prev = null;
            while(count>0&&cur!=null&&tries!=0){
                ListNode temp = cur.next;
                cur.next = prev;
                prev =cur;
                cur = temp;
                count--;
            }
            tries--;
            if(tries==0){
                ans.next=cur;
            }else{
                 ans.next = prev;
            }
            ans.next = prev;
            while(ans.next!=null){
                ans = ans.next;
            }
            count = k;
          }  
       ans.next = cur==null? null:cur;
        return test.next;
        }
}
