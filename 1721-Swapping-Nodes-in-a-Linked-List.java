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
    public ListNode swapNodes(ListNode head, int k) {
        int x=1;
        ListNode fast= head;
        while(x!=k)
        {
            fast= fast.next;
            x++;
        }
        ListNode left= fast;
        ListNode slow= head;
        while(fast.next!=null)
        {
            fast= fast.next;
            slow= slow.next;
        }
        x= left.val;
        left.val= slow.val;
        slow.val= x;
        return head;
    }
}