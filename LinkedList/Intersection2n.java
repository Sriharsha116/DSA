/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la=getlength(headA);
        int lb=getlength(headB);
        ListNode temp=headA;
        ListNode temp1=headB;
        while(la>lb){
           temp=temp.next;
           la--;
        }
        while(lb>la){
            temp1=temp1.next;
            lb--;
        }

        while(temp!=null || temp1!=null){
            if(temp==temp1){
                return temp;
            }
            temp=temp.next;
            temp1=temp1.next;
        }
        return null;
    }
    public int getlength(ListNode node){
        int count=1;
        while(node.next!=null){
            node=node.next;
            count++;
        }
        return count;
    }
}