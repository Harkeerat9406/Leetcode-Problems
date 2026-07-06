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
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead= new ListNode();
        ListNode prev= newHead;
        int sum;
        head= head.next;

        while(head!=null && head.next!=null)
        {
            sum=0;
            while(head.next!=null && head.val!=0)
            {
                sum+= head.val;
                head= head.next;
            }
            ListNode node= new ListNode(sum);
            prev.next= node;
            prev= node;
            head= head.next;
        }
        return newHead.next;
    }
}