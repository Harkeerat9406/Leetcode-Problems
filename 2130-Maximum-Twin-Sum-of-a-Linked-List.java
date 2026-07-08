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
    public int pairSum(ListNode head) {
        ListNode slow= head;
        ListNode fast= head.next;

        while(fast.next!=null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode mid= slow;
        ListNode dummy= null, ahead;
        slow= slow.next;
        ahead= slow.next;
        
        while(slow!=null)
        {
            slow.next= dummy;
            dummy= slow;
            slow= ahead;
            if(ahead!=null)
                ahead= ahead.next;
        }
        mid.next= dummy;
        mid= mid.next;
        int max= Integer.MIN_VALUE;
        ListNode temp= head;

        while(mid!=null)
        {
            max= Math.max(max, temp.val+mid.val);
            mid= mid.next;
            temp= temp.next;
        }
        return max;
    }
}