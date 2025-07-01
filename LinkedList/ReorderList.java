

class Solution {
    public void reorderList(ListNode head) {
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
      fast=reverseList(slow.next); // reverseing from the node where we reach middle
      slow.next=null;//setting the left prev last node pointing to null
      slow=head;
      ListNode middle=fast;

      while(fast!=null){
        ListNode first=slow.next;
        ListNode second=fast.next;
       
        slow.next=fast;
        fast.next=first;

        slow=first;
        fast=second;

     }
     System.out.println(fast);
     
    ListNode current = head;
    while (current != null) {
        System.out.print(current.val + " ");
        current = current.next;
    }
      

    }
    public ListNode reverseList(ListNode temp){
       
       ListNode prev=null;
       ListNode curr=temp;
       

       while(curr!=null){
         ListNode next=curr.next;
          curr.next=prev;
          prev=curr;
          curr=next;
          
       }
       return prev;

    }
}