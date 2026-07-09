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
    public ListNode mergeInBetween(ListNode head1, int a, int b, ListNode head2) {
        int counter= 0;
        ListNode beforeA= null, afterB=null;
        ListNode temp= head1;

        for(int i=0; i<=b+1; i++)
        {
            if(i == a-1)
                beforeA= temp;
            
            if(i == b+1)
                afterB= temp;
            
            temp= temp.next;
        }

        beforeA.next= head2;
        temp= head2;
        while(temp.next!=null)
            temp= temp.next;
        
        temp.next= afterB;
        return head1;
    }
}